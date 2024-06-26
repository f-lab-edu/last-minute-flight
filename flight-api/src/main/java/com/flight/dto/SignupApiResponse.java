package com.flight.dto;

public record SignupApiResponse(
	String name,
	String loginId,
	String email
) {
}
