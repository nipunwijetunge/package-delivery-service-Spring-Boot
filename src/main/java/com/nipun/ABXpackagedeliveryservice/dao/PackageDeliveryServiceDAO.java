package com.nipun.ABXpackagedeliveryservice.dao;

import java.sql.ResultSet;

import com.nipun.ABXpackagedeliveryservice.dto.PersonDTO;

public interface PackageDeliveryServiceDAO {
	ResultSet getData(String query) throws Exception;
	PersonDTO setCustomerData(PersonDTO customer, String query) throws Exception;
	void updateSeqNo(String packageTypeId) throws Exception;
	void updatePackageStatus(String status, String packageRegNo) throws Exception;
}
