package com.flight.common.dto;

public record MemberSessionInfo(
	String sessionId,
	Long memberId,
	String name,
	String email,
	String loginId
) {
}
