package com.flight.application.dto;

public record SignupServiceRequest(
	String name,
	String loginId,
	String password,
	String email
) {
}
