package com.nipun.ABXpackagedeliveryservice.service;

import com.nipun.ABXpackagedeliveryservice.request.PackageDeliveryRequest;
import com.nipun.ABXpackagedeliveryservice.response.PackageDeliveryResponse;

public interface PackageDeliveryService {
	PackageDeliveryResponse registerPackage(PackageDeliveryRequest pkg) throws Exception;
	PackageDeliveryResponse storePackage(PackageDeliveryRequest pkg) throws Exception;
	PackageDeliveryResponse assignPackage(PackageDeliveryRequest pkg) throws Exception;
}
