package com.nipun.ABXpackagedeliveryservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the employees and customers")
public class PersonDTO {
	@ApiModelProperty(notes = "Name of the Person")
	private String name;
	@ApiModelProperty(notes = "ID type of the person")
	private String idType;
	@ApiModelProperty(notes = "ID number of the person")
	private String id;
	@ApiModelProperty(notes = "Address of the person")
	private String address;
	@ApiModelProperty(notes = "Phone number of the person")
	private String phone;
	@ApiModelProperty(notes = "Email of the person")
	private String email;
	
	public PersonDTO() {
		
	}
	
	public PersonDTO(String id) {
		super();
		this.id = id;
	}

	public PersonDTO(String name, String idType, String id, String address, String phone, String email) {
		super();
		this.name = name;
		this.idType = idType;
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public PersonDTO(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIdType() {
		return idType;
	}
	
	public void setIdType(String idType) {
		this.idType = idType;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
