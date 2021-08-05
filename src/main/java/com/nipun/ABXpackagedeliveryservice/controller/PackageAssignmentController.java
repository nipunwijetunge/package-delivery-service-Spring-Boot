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
public class PackageAssignmentController {
	private static PackageDeliveryService service = PackageDeliveryServiceImpl.getInstance();
	private static PackageDeliveryRequest request;
	
	@RequestMapping(value = "/assignPackage", method = RequestMethod.POST)
	public PackageDeliveryResponse assignPackage(@RequestBody String json) {
		PackageDTO pkg = new Gson().fromJson(json, PackageDTO.class);
		request = new PackageDeliveryRequest(PackageDeliveryRequest.SUCCESS, "SUCCESS", "Package assignment details received", pkg);
		
		try {
			return service.assignPackage(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
