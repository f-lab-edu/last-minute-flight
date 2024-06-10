package com.flight.application.dto;

public record SignupServiceResponse(
	String name,
	String loginId,
	String email
) {
}
