package com.nipun.ABXpackagedeliveryservice.request;

import com.google.gson.JsonArray;
import com.nipun.ABXpackagedeliveryservice.dto.PackageDTO;

public class PackageDeliveryRequest {
	public static final int SUCCESS = 0;
	public static final int ERROR = -1;
	public static final int PRIMARY_KEY_VIOLATION = -2;
	public static final int DATA_ALREADY_EXISTS = -3;
	public static final int NO_DATA_FOUND = -4;
	
	private int id;
	private String status;
	private String description;
	private PackageDTO item;
	private JsonArray returnedData;
	
	public PackageDeliveryRequest() {}
	
	public PackageDeliveryRequest(int id, String status, String description, PackageDTO item) {
		this.id = id;
		this.status = status;
		this.description = description;
		this.item = item;
	}
	
	public PackageDeliveryRequest(int id, String status, String description, JsonArray jarr) {
		this.id = id;
		this.status = status;
		this.description = description;
		this.returnedData = jarr;
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

	public PackageDTO getItem() {
		return item;
	}

	public void setItem(PackageDTO item) {
		this.item = item;
	}

	public JsonArray getReturnedData() {
		return returnedData;
	}

	public void setReturnedData(JsonArray returnedData) {
		this.returnedData = returnedData;
	}
}
