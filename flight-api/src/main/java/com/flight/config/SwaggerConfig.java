package com.flight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI(){
		return new OpenAPI()
			.components(new Components())
			.info(apiInfo());
	}

	private Info apiInfo(){
		return new Info()
			.title("특가 항공권 판매 서비스 API")
			.description("특가 항공권 판매 서비스 API 입니다.")
			.version("1.0.0");
	}
}
