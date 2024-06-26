package com.flight.core.dto;

public record SignupDomainRequest(
	String name,
	String loginId,
	String password,
	String email
) {
}
