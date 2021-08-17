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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "Package Storing", value = "PackageStoring", description = "Controller for Package storing")
public class PackageStoringController {
	private static PackageDeliveryService service = PackageDeliveryServiceImpl.getInstance();
	private static PackageDeliveryRequest request;
	
	@RequestMapping(value = "/storePackage", method = RequestMethod.POST)
	@ApiOperation(value = "Stores a package")
	public PackageDeliveryResponse storePackage(@RequestBody PackageDTO pkg) {
		//PackageDTO pkg = new Gson().fromJson(json, PackageDTO.class);
		request = new PackageDeliveryRequest(PackageDeliveryRequest.SUCCESS, "SUCCESS", "Package storing details received", pkg);
		
		try {
			return service.storePackage(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
