package com.nipun.ABXpackagedeliveryservice.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;

@JsonFormat
public class PackageDeliveryResponse {
	public static final int SUCCESS = 0;
	public static final int ERROR = -1;
	public static final int PRIMARY_KEY_VIOLATION = -2;
	public static final int DATA_ALREADY_EXISTS = -3;
	public static final int NO_DATA_FOUND = -4;
	
	private int id;
	private String status;
	private String description;
	//private JsonArray returnedData;
	private List<JsonNode> returnedData;
	//private PackageRegNoQRResponse packageRegNoQR;
	
	public PackageDeliveryResponse() {
		super();
	}
	
	public PackageDeliveryResponse(int id, String status, String description) {
		super();
		this.id = id;
		this.status = status;
		this.description = description;
	}

//	public PackageDeliveryResponse(int id, String status, String description, String packageRegNoQR) {
//		this.id = id;
//		this.status = status;
//		this.description = description;
//		this.packageRegNoQR = new PackageRegNoQRResponse(packageRegNoQR);
//	}
	
//	public PackageDeliveryResponse(int id, String status, String description, JsonArray jarr) {
//		this.id = id;
//		this.status = status;
//		this.description = description;
//		this.returnedData = jarr;
//	}
	
	public PackageDeliveryResponse(int id, String status, String description, List<JsonNode> returnedData) {
		super();
		this.id = id;
		this.status = status;
		this.description = description;
		this.returnedData = returnedData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public JsonArray getReturnedData() {
//		return returnedData;
//	}
//
//	public void setReturnedData(JsonArray returnedData) {
//		this.returnedData = returnedData;
//	}
	public List<JsonNode> getReturnedData() {
		return returnedData;
	}

	public void setReturnedData(List<JsonNode> returnedData) {
		this.returnedData = returnedData;
	}
	
//	public PackageRegNoQRResponse getPackageRegNoQR() {
//		return packageRegNoQR;
//	}
//
//	public void setPackageRegNoQR(PackageRegNoQRResponse packageRegNoQR) {
//		this.packageRegNoQR = packageRegNoQR;
//	}
}
