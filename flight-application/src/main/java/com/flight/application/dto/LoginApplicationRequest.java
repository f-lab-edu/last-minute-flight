package com.flight.application.dto;

public record LoginApplicationRequest(
	String loginId,
	String password
) {
}
