package com.nipun.ABXpackagedeliveryservice.dto;

public class EmployeeDTO extends PersonDTO{
	private String password;
	private String dob;
	private String gender;

	public EmployeeDTO(String name, String id) {
		super(name, id);
	}

	public EmployeeDTO(String id) {
		super(id);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
