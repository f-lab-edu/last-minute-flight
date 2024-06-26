package com.flight.application.dto;

public record SignupApplicationRequest(
	String name,
	String loginId,
	String password,
	String email
) {
}
