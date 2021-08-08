package com.nipun.ABXpackagedeliveryservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
