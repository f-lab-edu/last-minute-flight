package com.flight.core.dto;

public record MemberDomainResponse(
	Long memberId,
	String name,
	String loginId,
	String email,
	String password
) {
}
