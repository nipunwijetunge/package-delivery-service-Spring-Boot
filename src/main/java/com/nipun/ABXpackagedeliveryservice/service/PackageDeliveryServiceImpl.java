package com.nipun.ABXpackagedeliveryservice.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.nipun.ABXpackagedeliveryservice.dao.PackageDeliveryServiceDAO;
import com.nipun.ABXpackagedeliveryservice.dao.PackageDeliveryServiceDAOImpl;
import com.nipun.ABXpackagedeliveryservice.dto.PackageDTO;
import com.nipun.ABXpackagedeliveryservice.dto.PersonDTO;
import com.nipun.ABXpackagedeliveryservice.request.PackageDeliveryRequest;
import com.nipun.ABXpackagedeliveryservice.response.PackageDeliveryResponse;

@Service
public class PackageDeliveryServiceImpl implements PackageDeliveryService{
	private static PackageDeliveryServiceImpl instance = null;
	private static DecimalFormat decimalFormatter = new DecimalFormat("00000");
	private static final Logger LOGGER = LogManager.getLogger(PackageDeliveryServiceImpl.class);
	
	private PackageDeliveryServiceDAO dao = new PackageDeliveryServiceDAOImpl();
	
	public static PackageDeliveryServiceImpl getInstance() {
		if (instance == null) {
			synchronized (PackageDeliveryServiceImpl.class) {
				if (instance == null) {
					instance = new PackageDeliveryServiceImpl();
				}
			}
		}
		return instance;
	}
	
	@Override
	public PackageDeliveryResponse getCustomerIdTypes() throws Exception {
		LOGGER.info("PackageDeliveryServiceImpl | getCustomerIdTypes called");
		String query = "SELECT * FROM customeridtype";
		ResultSet rs = dao.getData(query);
		
		List<JsonNode> list = new ArrayList<>();
		while(rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode jNode = mapper.createObjectNode();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				jNode.put(columnName, value);
			}
			list.add(jNode);
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		
		PackageDeliveryResponse response = new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Customer ID type data", list);
		LOGGER.info("PackageDeliveryServiceImpl | getCustomerIdTypes end");
		return response;
	}
	
	@Override
	public PackageDeliveryResponse getPackageTypes() throws Exception {
		String query = "SELECT * FROM packagetype";
		ResultSet rs = dao.getData(query);
		
		List<JsonNode> list = new ArrayList<>();
		while(rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode jNode = mapper.createObjectNode();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				jNode.put(columnName, value);
			}
			list.add(jNode);
		}
		
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		
		PackageDeliveryResponse response = new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Package type data", list);
		return response;
	}
	
	@Override
	public PackageDeliveryResponse getPackageWeightCategories() throws Exception {
		String query = "SELECT * FROM packageweightcategory";
		ResultSet rs = dao.getData(query);
		
		List<JsonNode> list = new ArrayList<>();
		while(rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode jNode = mapper.createObjectNode();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				jNode.put(columnName, value);
			}
			list.add(jNode);
		}
		
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		
		PackageDeliveryResponse response = new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Package weight category data", list);
		return response;
	}
	
	// retrieves delivery types from the DB
	@Override
	public PackageDeliveryResponse getDeliveryTypes() throws Exception {
		String query = "SELECT * FROM deliverytype";
		ResultSet rs = dao.getData(query);
		
		List<JsonNode> list = new ArrayList<>();
		while(rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode jNode = mapper.createObjectNode();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				jNode.put(columnName, value);
			}
			list.add(jNode);
		}
		
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		
		PackageDeliveryResponse response = new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Package weight category data", list);
		return response;
	}
	
	@Override
	public PackageDeliveryResponse getStoreData() throws Exception {
		String query = "SELECT * FROM store";
		ResultSet rs = dao.getData(query);
		
		List<JsonNode> list = new ArrayList<>();
		while(rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode jNode = mapper.createObjectNode();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				jNode.put(columnName, value);
			}
			list.add(jNode);
		}
		
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		
		PackageDeliveryResponse response = new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Store data", list);
		return response;
	}
	
	@Override
	public PackageDeliveryResponse getCupboardData(PackageDTO pkg) throws Exception {
		String query = "SELECT cupboardID FROM cupboard WHERE storeroomID="+pkg.getStoreId();
		ResultSet rs = dao.getData(query);
		
		List<JsonNode> list = new ArrayList<>();
		while(rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode jNode = mapper.createObjectNode();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				jNode.put(columnName, value);
			}
			list.add(jNode);
		}
		
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		
		PackageDeliveryResponse response = new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Cupboard data", list);
		return response;
	}
	
	// retrieves bearer or receiver data from the DB
	private JsonArray getCustomerData(String query) throws Exception {
		ResultSet rs = dao.getData(query);
		JsonArray jarr = new JsonArray();
		
		while (rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			JsonObject jObj = new JsonObject();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				jObj.addProperty(columnName, value);
			}
			jarr.add(jObj);
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		return jarr;
	}
		
	// returns package type id according to selected value to store in DB
	private String setPackageTypeData(String packageTypeId) throws Exception {
		String query = "SELECT packageTypeId FROM packagetype "
				+ "WHERE packageTypeId='"+packageTypeId+"'";
		ResultSet rs = dao.getData(query);

		while (rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				return value;
			}
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		return null;
	}
	
	// returns weight category id to store in package table
	private String setWeightData(int weightRangeId) throws Exception {
		String query = "SELECT weightCategoryId FROM packageweightcategory "
				+ "WHERE weightCategoryId="+weightRangeId;
		ResultSet rs = dao.getData(query);

		while (rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				return value;
			}
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		return null;
	}
	
	// returns respective delivery type id to delivery type
	private String setDeliveryTypeData(int deliveryTypeId) throws Exception {
		String query = "SELECT deliveryTypeId FROM deliverytype "
				+ "WHERE deliveryTypeId="+deliveryTypeId;
		ResultSet rs = dao.getData(query);
		
		while (rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				return value;
			}
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		return null;
	}
	
	// returns package registration number to from m_package_registry table
	private String setPackageRegNoData(String packageRegistrationNo) throws Exception {
		String query = "SELECT packageRegistrationNo FROM m_package_registry "
				+ "WHERE packageRegistrationNo='"+packageRegistrationNo+"'";
		ResultSet rs = dao.getData(query);
		
		while (rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				return value;
			}
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		return null;
	}
	
	// returns respective store room id to cupboard id in cupboard table
	private int setStoreData(int storeId) throws Exception {
		String query = "SELECT storeID FROM store "
				+ "WHERE storeID="+storeId;
		ResultSet rs = dao.getData(query);
		
		while (rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				int value = rs.getInt(columnName);
				return value;
			}
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		return 0;
	}
	
	// returns cupboard id from cupboard table if exists
	private int setCupboardData(int cupboardId) throws Exception {
		String query = "SELECT cupboardID FROM cupboard "
				+ "WHERE cupboardID="+cupboardId;
		ResultSet rs = dao.getData(query);
		
		while (rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				int value = rs.getInt(columnName);
				return value;
			}
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		return 0;
	}
	
	// returns employee id from employee table if exists
	private String setEmployeeData(String employeeId) throws Exception {
		String query = "SELECT employeeID FROM employee "
				+ "WHERE employeeID='"+employeeId+"'";
		ResultSet rs = dao.getData(query);
		
		while (rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				
				if (dao.getCon() != null) {
					dao.getCon().close();
				}
				
				return value;
			}
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		return null;
	}
	
	// generates package registration number for each package registration
	private String generatePackageRegNo(String packageTypeId) throws Exception {
		dao.updateSeqNo(packageTypeId);
		String query = "SELECT YEAR(year) AS year, seqNo, packageTypeId "
				+ "FROM m_package_sequence "
				+ "WHERE packageTypeId='"+packageTypeId+"'";
		ResultSet rs = dao.getData(query);
		
		String packageRegistrationNo = "";
		while(rs.next()) {
			int totalColumns = rs.getMetaData().getColumnCount();
			JsonObject jObj = new JsonObject();
			for (int i = 1; i <= totalColumns; i++) {
				String columnName = rs.getMetaData().getColumnLabel(i);
				String value = rs.getString(columnName);
				jObj.addProperty(columnName, value);
			}
			String formattedSeqNo = decimalFormatter.format(jObj.get("seqNo").getAsDouble());
			packageRegistrationNo = jObj.get("year").getAsString()+"/"+jObj.get("packageTypeId").getAsString()+"/"+formattedSeqNo;
		}
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		return packageRegistrationNo;
	}
	
	// validates customer id number
	private PackageDeliveryResponse validateCustomerDetails(int customerIdTypeId, String customerId) {
		switch (customerIdTypeId) {
			case 1:
				if (customerId.matches("^[0-9]{9}[x|X|v|V]|[0-9]{12}$")) {
					return new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "NIC number is valid");
				} else {
					return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "NIC number is invalid");
				}
				
			case 2:
				if (customerId.matches("^[N|OL|D][0-9]{7}$")) {
					return new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Passport number is valid");
				} else {
					return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Passport number is invalid");
				}
				
	//		case 3:
	//			if (customerId.matches())
			default:
				return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Invalid ID type");
		}
	}
	
	// validates phone numbers
	private PackageDeliveryResponse validatePhoneNumber(String phone) {
		if (phone.matches("^[0-9]{10}$")) {
			return new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Phone number is valid");
		} else {
			return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Phone number is invalid");
		}
	}
	
	// validate email
	private PackageDeliveryResponse validateEmail(String email) {
		if (email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$")) {
			return new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Email is valid");
		} else {
			return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Email is invalid");
		}
	}

	// registers package and store registration data in database
	@Override
	public PackageDeliveryResponse registerPackage(PackageDeliveryRequest pkg) throws Exception {
		PreparedStatement pstmt = dao.packageRegistration();
		
		String packageRegistrationNo = generatePackageRegNo(setPackageTypeData(pkg.getItem().getPackageTypeId()));
		
		pstmt.setString(1, packageRegistrationNo);
		pstmt.setString(2, setPackageTypeData(pkg.getItem().getPackageTypeId()));
		pstmt.setString(3, setWeightData(pkg.getItem().getPackageWeightRangeId()));
		
		// checks whether bearer is already exists in bearer table 
		
		boolean bearerIdFlag = validateCustomerDetails(Integer.parseInt(pkg.getItem().getBearer().getIdType()), pkg.getItem().getBearer().getId()).getId() == 0;
		boolean bearerPhoneFlag = validatePhoneNumber(pkg.getItem().getBearer().getPhone()).getId() == 0;
		boolean bearerEmailFlag = validateEmail(pkg.getItem().getBearer().getEmail()).getId() == 0;
		
		boolean bearerExist = false;
		PersonDTO bearer;
		
		if (!bearerIdFlag) {
			return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Bearer ID is invalid");
		}
		
		if (!bearerPhoneFlag) {
			return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Bearer phone is invalid");
		} 
		
		if (!bearerEmailFlag) {
			return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Bearer email is invalid");
		}
		
		if (bearerIdFlag && bearerPhoneFlag && bearerEmailFlag) {
			for (JsonElement user : getCustomerData("SELECT bearerID FROM bearer")) {
				JsonObject obj = user.getAsJsonObject();
				if (obj.get("bearerID").getAsString().equalsIgnoreCase(pkg.getItem().getBearer().getId())) {
					bearerExist = true;
					break;
				}
			}
			if (!bearerExist) {
				bearer = dao.setCustomerData(pkg.getItem().getBearer(), "INSERT INTO bearer "
						+ "VALUES(?,?,?,?,?,?)");
			} else {
				bearer = pkg.getItem().getBearer();
				//return new Response(Response.DATA_ALREADY_EXISTS, "DATA EXISTS", "Bearer already exists in database");
			}
			pstmt.setString(4, bearer.getId());
		}
		//
		
		// checks whether receiver is already exists in receiver table
		
		boolean receiverIdFlag = validateCustomerDetails(Integer.parseInt(pkg.getItem().getReciever().getIdType()), pkg.getItem().getReciever().getId()).getId() == 0;
		boolean receiverPhoneFlag = validatePhoneNumber(pkg.getItem().getReciever().getPhone()).getId() == 0;
		boolean receiverEmailFlag = validateEmail(pkg.getItem().getReciever().getEmail()).getId() == 0;
		
		boolean recieverExist = false;
		PersonDTO reciever;
		
		if (!receiverIdFlag) {
			return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Reciever ID is invalid");
		}
		
		if (!receiverPhoneFlag) {
			return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Reciever phone is invalid");
		}
		
		if (!receiverEmailFlag) {
			return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Reciever email is invalid");
		}
		
		if (receiverIdFlag && receiverPhoneFlag && receiverEmailFlag) {
			for (JsonElement user : getCustomerData("SELECT recieverID FROM reciever")) {
				JsonObject obj = user.getAsJsonObject();
				if (obj.get("recieverID").getAsString().equalsIgnoreCase(pkg.getItem().getReciever().getId())) {
					recieverExist = true;
					break;
				}
			}
			if (!recieverExist) {
				reciever = dao.setCustomerData(pkg.getItem().getReciever(), "INSERT INTO reciever "
						+ "VALUES(?,?,?,?,?,?)");
			} else  {
				reciever = pkg.getItem().getReciever();
				//return new Response(Response.DATA_ALREADY_EXISTS, "DATA EXISTS", "Reciever already exists in database");
			}
			pstmt.setString(5, reciever.getId());
		}
		//
		
		pstmt.setString(6, setDeliveryTypeData(pkg.getItem().getDeliveryTypeId()));
		pstmt.setNull(7, Types.VARCHAR);
		pstmt.setString(8, "Registered");
		
		pstmt.executeUpdate();
		
		if (dao.getCon() != null) {
			dao.getCon().close();
		}
		
		QRCodeGenerator qrCode = new QRCodeGeneratorImpl();
		
		return qrCode.createCode(packageRegistrationNo);
	}

	// stores package and save store data in database
	@Override
	public PackageDeliveryResponse storePackage(PackageDeliveryRequest pkg) throws Exception {
		PreparedStatement pstmt = dao.packageStoring();
		
		String checkRegNoQuery = "SELECT packageRegistrationNo FROM m_package_store "
				+ "WHERE packageRegistrationNo='"+pkg.getItem().getPackageRegistrationNo()+"'";
		String checkPackageInRegistry = "SELECT packageRegistrationNo FROM m_package_registry "
				+ "WHERE packageRegistrationNo='"+pkg.getItem().getPackageRegistrationNo()+"'";
		String checkPackageWhetherAssigned = "SELECT packageRegistrationNo FROM m_package_assignment "
				+ "WHERE packageRegistrationNo='"+pkg.getItem().getPackageRegistrationNo()+"'";
		
		ResultSet rs = dao.getData(checkRegNoQuery);
		ResultSet rs1 = dao.getData(checkPackageInRegistry);
		ResultSet rs3 = dao.getData(checkPackageWhetherAssigned);
		
		if(!rs3.next()) {
			if (!rs.next()) {
				if (rs1.next()) {
					pstmt.setString(1, setPackageRegNoData(pkg.getItem().getPackageRegistrationNo()));
					pstmt.setInt(2, setStoreData(pkg.getItem().getStoreId()));
					pstmt.setInt(3, setCupboardData(pkg.getItem().getCupboardId()));
					
					boolean employeeValidation = pkg.getItem().getStoredOfficer().getId().matches("^[SDRM][0-9]{3}$");
					
					if (!employeeValidation || setEmployeeData(pkg.getItem().getStoredOfficer().getId()) == null) {
						return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Invalid employee ID");
					} else {
						pstmt.setString(4, setEmployeeData(pkg.getItem().getStoredOfficer().getId()));
					}
					
					dao.updatePackageStatus("Stored", setPackageRegNoData(pkg.getItem().getPackageRegistrationNo()));
					
					pstmt.executeUpdate();
					
					if (dao.getCon() != null) {
						dao.getCon().close();
					}
					
					return new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Package successfully stored");
				} else {
					return new PackageDeliveryResponse(PackageDeliveryResponse.NO_DATA_FOUND, "FAILED", "No such package has been registered");
				}
			} else {
				return new PackageDeliveryResponse(PackageDeliveryResponse.DATA_ALREADY_EXISTS, "FAILED", "The package has already been stored");
			}
		} else {
			return new PackageDeliveryResponse(PackageDeliveryResponse.DATA_ALREADY_EXISTS, "FAILED", "The package has already been assigned");
		}
	}

	// assigns package to delivery officer and store assignment data in database
	@Override
	public PackageDeliveryResponse assignPackage(PackageDeliveryRequest pkg) throws Exception {
		PreparedStatement pstmt = dao.packageAssignment();
		PreparedStatement pstmt1 = dao.packageDeleteFromStore();
		
		String checkRegNoQuery = "SELECT packageRegistrationNo FROM m_package_assignment "
				+ "WHERE packageRegistrationNo='"+pkg.getItem().getPackageRegistrationNo()+"'";
		String checkRegNoQueryInStore = "SELECT packageRegistrationNo FROM m_package_store "
				+ "WHERE packageRegistrationNo='"+pkg.getItem().getPackageRegistrationNo()+"'";
		
		ResultSet rs = dao.getData(checkRegNoQuery);
		ResultSet rs1 = dao.getData(checkRegNoQueryInStore);
		
		if (!rs.next()) {
			if (rs1.next()) {
				pstmt.setString(1, setPackageRegNoData(pkg.getItem().getPackageRegistrationNo()));
				
				boolean employeeValidation = pkg.getItem().getAssigner().getId().matches("^[SDRM][0-9]{3}$");
				
				if (!employeeValidation || setEmployeeData(pkg.getItem().getAssigner().getId()) == null) {
					return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Invalid assigner ID");
				} else {
					pstmt.setString(2, setEmployeeData(pkg.getItem().getAssigner().getId()));
				}
				
				employeeValidation = pkg.getItem().getAssignee().getId().matches("^[SDRM][0-9]{3}$");
				
				if (!employeeValidation || setEmployeeData(pkg.getItem().getAssignee().getId()) == null) {
					return new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Invalid assignee ID");
				} else {
					pstmt.setString(3, setEmployeeData(pkg.getItem().getAssignee().getId()));
				}
				
				dao.updatePackageStatus("Assigned", setPackageRegNoData(pkg.getItem().getPackageRegistrationNo()));
				
				pstmt1.setString(1, setPackageRegNoData(pkg.getItem().getPackageRegistrationNo()));
				
				pstmt.executeUpdate();
				pstmt1.executeUpdate();
				
				if (dao.getCon() != null) {
					dao.getCon().close();
				}
				
				return new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Package successfully assigned");
			} else {
				return new PackageDeliveryResponse(PackageDeliveryResponse.NO_DATA_FOUND, "FAILED", "No such package found in store");
			}
		} else {
			return new PackageDeliveryResponse(PackageDeliveryResponse.DATA_ALREADY_EXISTS, "FAILED", "The package has already been assigned");
		}
	}
	
}
