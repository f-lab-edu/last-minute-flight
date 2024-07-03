package com.flight.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.flight.interceptor.AuthInterceptor;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

	private final AuthInterceptor authInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry
			.addInterceptor(authInterceptor)
			.addPathPatterns()
			.excludePathPatterns("/login", "/signup", "/flightsInfo", "/swagger-ui/**", "/v3/api-docs/**");

		WebMvcConfigurer.super.addInterceptors(registry);
	}
}
