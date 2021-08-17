package com.nipun.ABXpackagedeliveryservice.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@Api(tags = "Package Assignment", value = "PackageAssignement", description = "Controller for Package assignment")
public class PackageAssignmentController {
	private static PackageDeliveryService service = PackageDeliveryServiceImpl.getInstance();
	private static PackageDeliveryRequest request;
	
	@RequestMapping(value = "/assignPackage", method = RequestMethod.POST)
	@ApiOperation(value = "Assigns a package")
	public PackageDeliveryResponse assignPackage(@RequestBody PackageDTO pkg) {
		//PackageDTO pkg = new Gson().fromJson(json, PackageDTO.class);
		request = new PackageDeliveryRequest(PackageDeliveryRequest.SUCCESS, "SUCCESS", "Package assignment details received", pkg);
		
		try {
			return service.assignPackage(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
