package com.management.CustomerMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
public class CustomerApplication {
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
		
	}
	
	 @Bean
	    public Docket customerApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	               .select()
	               .apis(RequestHandlerSelectors.basePackage("com.management.CustomerMS"))
	               //PathSelectors.any() for all
	               .build().apiInfo(apiDetails());
	    }
	 
	 private ApiInfo apiDetails() {
	        @SuppressWarnings("deprecation")
			ApiInfo apiInfo = new ApiInfo(
	                "Customer Insurance API",
	                "This API will provide information about customer insurance details",
	                "1.0.0",
	                "Free to use",
	                "cust@org.com",
	                "API license: Apache 2.0",
	                "http://www.apache.org/licenses/LICENSE-2.0.html");
	        return apiInfo;
	    }
}

