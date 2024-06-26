package com.flight.common.dto;

public record MemberSessionInfo(
	String sessionId,
	String name,
	String email,
	String loginId
) {
}
