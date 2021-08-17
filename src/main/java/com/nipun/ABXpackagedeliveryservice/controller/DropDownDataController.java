package com.nipun.ABXpackagedeliveryservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nipun.ABXpackagedeliveryservice.dto.PackageDTO;
import com.nipun.ABXpackagedeliveryservice.request.PackageDeliveryRequest;
import com.nipun.ABXpackagedeliveryservice.response.PackageDeliveryResponse;
import com.nipun.ABXpackagedeliveryservice.service.PackageDeliveryService;
import com.nipun.ABXpackagedeliveryservice.service.PackageDeliveryServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "Drop Down List Requests", value = "DropDownListRequests", description = "Controller for drop down list content")
public class DropDownDataController {
	
	@Autowired
	private static PackageDeliveryService service = PackageDeliveryServiceImpl.getInstance();
	
	@RequestMapping(value = "/getCustomerIdTypes", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get customer ID types")
	public PackageDeliveryResponse getCustomerIdTypes() {
		try {
			return service.getCustomerIdTypes();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getPackageTypes", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get package types")
	public PackageDeliveryResponse getPackageTypes() {
		try {
			return service.getPackageTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getPackageWeightCategories", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get package weight categories")
	public PackageDeliveryResponse getPackageWeightCategories() {
		try {
			return service.getPackageWeightCategories();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getDeliveryTypes", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get package delivery types")
	public PackageDeliveryResponse getDeliveryTypes() {
		try {
			return service.getDeliveryTypes();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getStoreData", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get store data")
	public PackageDeliveryResponse getStoreData() {
		try {
			return service.getStoreData();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getCupboardData", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "Get cupboard data")
	public PackageDeliveryResponse getCupboardData(@RequestParam int storeId) {
		try {
			return service.getCupboardData(storeId);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
