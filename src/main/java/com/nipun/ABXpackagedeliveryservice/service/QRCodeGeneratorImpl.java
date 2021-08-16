package com.nipun.ABXpackagedeliveryservice.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.nipun.ABXpackagedeliveryservice.dto.PackageRegNoQrDTO;
import com.nipun.ABXpackagedeliveryservice.response.PackageDeliveryResponse;

public class QRCodeGeneratorImpl implements QRCodeGenerator{
	private static final Logger LOGGER = LogManager.getLogger(PackageDeliveryServiceImpl.class);
	
	// generates QR code in png format and encode into a base64 string
	@Override
	public PackageDeliveryResponse createCode(String content) {
		int width = 200;
		int height = 200;
		
		Map<EncodeHintType, Object> hints = new HashMap<>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		hints.put(EncodeHintType.MARGIN, 0);
		
		BitMatrix bitMatrix = null;
		
		try {
			bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(bitMatrix, "png", bos);
			
			String qrBase64String = Base64.getEncoder().encodeToString(bos.toByteArray());
			PackageRegNoQrDTO qrDto = new PackageRegNoQrDTO(qrBase64String);
			
			//JsonObject JObj = new JsonObject();
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jNode = mapper.valueToTree(qrDto);
			
			List<JsonNode> list = new ArrayList<>();
			list.add(jNode);
			
			return new PackageDeliveryResponse(PackageDeliveryResponse.SUCCESS, "SUCCESS", "Package Successfully registered!", list);
			
		} catch (Exception e) {
			LOGGER.error("PackageDeliveryServiceImpl | something went wrong when generating qr code");
			PackageDeliveryResponse response = new PackageDeliveryResponse(PackageDeliveryResponse.ERROR, "FAILED", "Something's wrong!");
			e.printStackTrace();
			return response;
		}
	}
	
//	public static void decodeImage(String baseTxt, String savePath) throws Exception {
//		byte[] data = Base64.getDecoder().decode(baseTxt);
//		
//		FileOutputStream fos = new FileOutputStream(savePath);
//		fos.write(data);
//		fos.close();
//	}
//	
//	public static void main(String[] args) throws Exception {
//		decodeImage(createCode("2021/EL/00001").getPackageRegNoQR().getPackageRegNoQR(), "C:\\Users\\Nipun\\Desktop\\image.png");
//	}
}
