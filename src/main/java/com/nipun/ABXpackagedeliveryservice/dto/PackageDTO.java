package com.nipun.ABXpackagedeliveryservice.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the package")
public class PackageDTO {
	@ApiModelProperty(notes = "Package registration no.")
	private String packageRegistrationNo;
	@ApiModelProperty(notes = "Package Type ID")
	private String packageTypeId;
	@ApiModelProperty(notes = "Package weight category ID")
	private int packageWeightRangeId;
	
	@ApiModelProperty(notes = "The bearer of the package")
	private PersonDTO bearer;
	@ApiModelProperty(notes = "The receiver of the package")
	private PersonDTO reciever;
	
	@ApiModelProperty(notes = "Package delivery type ID")
	private int deliveryTypeId;
	@ApiModelProperty(notes = "Package delivery Date")
	private String deliveryDate;
	
	@ApiModelProperty(notes = "The employee who stored the package.")
	private PersonDTO storedOfficer;
	@ApiModelProperty(notes = "The store ID that the package has been stored")
	private int storeId;
	@ApiModelProperty(notes = "The cupboard ID that the package has been stored")
	private int cupboardId;
	
	@ApiModelProperty(notes = "The employee that assigned the package to assignee")
	private PersonDTO assigner;
	@ApiModelProperty(notes = "The employee that was assigned the package to")
	private PersonDTO assignee;
	
	@ApiModelProperty(notes = "Current status of the package")
	private String packageStatus;

	public PackageDTO(String packageTypeId, int packageWeightRangeId, PersonDTO bearer, PersonDTO reciever,
			int deliveryTypeId, String deliveryDate) {
		super();
		this.packageTypeId = packageTypeId;
		this.packageWeightRangeId = packageWeightRangeId;
		this.bearer = bearer;
		this.reciever = reciever;
		this.deliveryTypeId = deliveryTypeId;
		this.deliveryDate = deliveryDate;
	}

	public String getPackageRegistrationNo() {
		return packageRegistrationNo;
	}

	public void setPackageRegistrationNo(String packageRegistrationNo) {
		this.packageRegistrationNo = packageRegistrationNo;
	}

	public String getPackageTypeId() {
		return packageTypeId;
	}

	public void setPackageTypeId(String packageTypeId) {
		this.packageTypeId = packageTypeId;
	}

	public int getPackageWeightRangeId() {
		return packageWeightRangeId;
	}

	public void setPackageWeightRangeId(int packageWeightRangeId) {
		this.packageWeightRangeId = packageWeightRangeId;
	}

	public PersonDTO getBearer() {
		return bearer;
	}

	public void setBearer(PersonDTO bearer) {
		this.bearer = bearer;
	}

	public PersonDTO getReciever() {
		return reciever;
	}

	public void setReciever(PersonDTO reciever) {
		this.reciever = reciever;
	}

	public int getDeliveryTypeId() {
		return deliveryTypeId;
	}

	public void setDeliveryTypeId(int deliveryTypeId) {
		this.deliveryTypeId = deliveryTypeId;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public PersonDTO getStoredOfficer() {
		return storedOfficer;
	}

	public void setStoredOfficer(PersonDTO storedOfficer) {
		this.storedOfficer = storedOfficer;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getCupboardId() {
		return cupboardId;
	}

	public void setCupboardId(int cupboardId) {
		this.cupboardId = cupboardId;
	}

	public PersonDTO getAssigner() {
		return assigner;
	}

	public void setAssigner(PersonDTO assigner) {
		this.assigner = assigner;
	}

	public PersonDTO getAssignee() {
		return assignee;
	}

	public void setAssignee(PersonDTO assignee) {
		this.assignee = assignee;
	}

	public String getPackageStatus() {
		return packageStatus;
	}

	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}
}
