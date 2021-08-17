package com.nipun.ABXpackagedeliveryservice;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class AbxPackageDeliveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AbxPackageDeliveryServiceApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.nipun.ABXpackagedeliveryservice"))
				.build()
				.apiInfo(getApiInformation());
	}
	
	private ApiInfo getApiInformation(){
        return new ApiInfo("ABX API",
                "This is the official documentaion of ABX package delivery service API",
                "1.0",
                "API Terms of Service URL",
                new Contact("Nipun Wijetunge", "https://github.com/nipunwijetunge", "nipun.w@informaticsint.com"),
                "API License",
                "API License URL",
                Collections.emptyList()
                );
    }

}