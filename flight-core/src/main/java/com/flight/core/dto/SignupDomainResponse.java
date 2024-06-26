package com.flight.core.dto;

public record SignupDomainResponse(
	String name,
	String loginId,
	String email
) {
}
