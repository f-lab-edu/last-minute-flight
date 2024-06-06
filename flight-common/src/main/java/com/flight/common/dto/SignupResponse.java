package com.flight.common.dto;

public record SignupResponse(
	String name,
	String loginId,
	String email) {
}
