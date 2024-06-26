package com.flight.dto;

import com.flight.common.exception.ErrorCode.ClientMessage;

import jakarta.validation.constraints.NotBlank;

public record LoginApiRequest(
	@NotBlank(message = ClientMessage.EMPTY_MEMBER_LOGIN_ID)
	String loginId,
	@NotBlank(message = ClientMessage.EMPTY_MEMBER_LOGIN_PASSWORD)
	String password
) {
}
