package com.nipun.ABXpackagedeliveryservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.nipun.ABXpackagedeliveryservice.dto.PackageDTO;
import com.nipun.ABXpackagedeliveryservice.request.PackageDeliveryRequest;
import com.nipun.ABXpackagedeliveryservice.response.PackageDeliveryResponse;
import com.nipun.ABXpackagedeliveryservice.service.PackageDeliveryService;
import com.nipun.ABXpackagedeliveryservice.service.PackageDeliveryServiceImpl;

@RestController
public class DropDownDataController {
	private static PackageDeliveryService service = PackageDeliveryServiceImpl.getInstance();
	
	@RequestMapping(value = "/getCustomerIdTypes", method = RequestMethod.GET)
	public PackageDeliveryResponse getCustomerIdTypes() {
		try {
			return service.getCustomerIdTypes();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getPackageTypes", method = RequestMethod.GET)
	public PackageDeliveryResponse getPackageTypes() {
		try {
			return service.getPackageTypes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getPackageWeightCategories", method = RequestMethod.GET)
	public PackageDeliveryResponse getPackageWeightCategories() {
		try {
			return service.getPackageWeightCategories();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getDeliveryTypes", method = RequestMethod.GET)
	public PackageDeliveryResponse getDeliveryTypes() {
		try {
			return service.getDeliveryTypes();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getStoreData", method = RequestMethod.GET)
	public PackageDeliveryResponse getStoreData() {
		try {
			return service.getStoreData();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/getCupboardData", method = RequestMethod.POST)
	public PackageDeliveryResponse getCupboardData(@RequestBody String json) {
		PackageDTO pkg = new Gson().fromJson(json, PackageDTO.class);
		
		try {
			return service.getCupboardData(pkg);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
