package com.nipun.ABXpackagedeliveryservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.google.gson.JsonObject;
import com.nipun.ABXpackagedeliveryservice.dto.PersonDTO;
import com.nipun.ABXpackagedeliveryservice.response.PackageDeliveryResponse;

public class PackageDeliveryServiceDAOImpl implements PackageDeliveryServiceDAO{
	private static Connection con = null;
	
	@Override
	public ResultSet getData(String query) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url = "jdbc:mysql://localhost:3306/abxpackagedeliveryservice";
		con = DriverManager.getConnection(url, "root", "");
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		return rs;
	}
	
	@Override
	public PersonDTO setCustomerData(PersonDTO customer, String query) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url = "jdbc:mysql://localhost:3306/abxpackagedeliveryservice";
		con = DriverManager.getConnection(url, "root", "");
		
		PreparedStatement pstmt = con.prepareStatement(query);
		pstmt.setString(1, customer.getId());
		pstmt.setString(2, customer.getName());
		pstmt.setString(3, customer.getAddress());
		pstmt.setString(4, customer.getPhone());
		pstmt.setString(5, customer.getEmail());
		pstmt.setString(6, customer.getIdType());
		
		pstmt.executeUpdate();
		
		if (con != null) {
			con.close();
		}
		return customer;
	}
	
	@Override
	public void updateSeqNo(String packageTypeId) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url = "jdbc:mysql://localhost:3306/abxpackagedeliveryservice";
		con = DriverManager.getConnection(url, "root", "");
		
		String selectQuery = "SELECT seqNo FROM m_package_sequence "
				+ "WHERE packageTypeId='"+packageTypeId+"'";
		ResultSet rs = getData(selectQuery);
		
		JsonObject jObj = new JsonObject();
		while (rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				int value = rs.getInt(columnName);
				jObj.addProperty(columnName, value);
			}
		}
		
		String updateQuery = "UPDATE m_package_sequence SET seqNo=? "
				+ "WHERE packageTypeId='"+packageTypeId+"'";
		PreparedStatement pstmt = con.prepareStatement(updateQuery);
		
		pstmt.setInt(1, Integer.parseInt(jObj.get("seqNo").getAsString())+1);
		pstmt.executeUpdate();
		
		if (con != null) {
			con.close();
		}
	}
	
	@Override
	public void updatePackageStatus(String status, String packageRegNo) throws Exception {
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		String url = "jdbc:mysql://localhost:3306/abxpackagedeliveryservice";
		con = DriverManager.getConnection(url, "root", "");
		
		String query = "UPDATE m_package_registry "
				+ "SET packageStatus=? "
				+ "WHERE packageRegistrationNo='"+packageRegNo+"'";
		PreparedStatement pstmt = con.prepareStatement(query);
		
		pstmt.setString(1, status);
		
		pstmt.executeUpdate();
	}
}
