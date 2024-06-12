package com.flight.core.dto;

public record MemberDomainResponse(
	String name,
	String loginId,
	String email,
	String password
) {
}
