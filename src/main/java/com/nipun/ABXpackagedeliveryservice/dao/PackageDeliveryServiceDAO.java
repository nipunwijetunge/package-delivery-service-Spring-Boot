package com.nipun.ABXpackagedeliveryservice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nipun.ABXpackagedeliveryservice.dto.PersonDTO;

public interface PackageDeliveryServiceDAO {
	Connection getCon();
	void setCon(Connection con);
	ResultSet getData(String query) throws Exception;
	PersonDTO setCustomerData(PersonDTO customer, String query) throws Exception;
	void updateSeqNo(String packageTypeId) throws Exception;
	void updatePackageStatus(String status, String packageRegNo) throws Exception;
	PreparedStatement packageRegistration() throws Exception;
	PreparedStatement packageStoring() throws Exception;
	PreparedStatement packageAssignment() throws Exception;
	PreparedStatement packageDeleteFromStore() throws Exception;
}
