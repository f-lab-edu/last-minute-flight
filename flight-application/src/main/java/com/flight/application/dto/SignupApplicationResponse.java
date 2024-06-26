package com.flight.application.dto;

public record SignupApplicationResponse(
	String name,
	String loginId,
	String email
) {
}
