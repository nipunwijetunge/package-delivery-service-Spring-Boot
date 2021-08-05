package com.nipun.ABXpackagedeliveryservice.service;

import com.nipun.ABXpackagedeliveryservice.response.PackageDeliveryResponse;

public interface QRCodeGenerator {
	PackageDeliveryResponse createCode(String content);
}
