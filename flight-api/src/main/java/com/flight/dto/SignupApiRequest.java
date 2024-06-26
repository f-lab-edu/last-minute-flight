package com.flight.dto;

import com.flight.common.constant.InputPattern;
import com.flight.common.exception.ErrorCode;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record SignupApiRequest(

	@NotNull(message = ErrorCode.ClientMessage.INVALID_MEMBER_NAME_PATTERN)
	@Pattern(regexp = InputPattern.MEMBER_NAME_PATTERN, message = ErrorCode.ClientMessage.INVALID_MEMBER_NAME_PATTERN)
	String name,

	@NotNull(message = ErrorCode.ClientMessage.INVALID_MEMBER_LOGIN_ID_PATTERN)
	@Pattern(regexp = InputPattern.MEMBER_LOGIN_ID_PATTERN, message = ErrorCode.ClientMessage.INVALID_MEMBER_LOGIN_ID_PATTERN)
	String loginId,

	@NotNull(message = ErrorCode.ClientMessage.INVALID_MEMBER_PASSWORD_PATTERN)
	@Pattern(regexp = InputPattern.MEMBER_PASSWORD_PATTERN, message = ErrorCode.ClientMessage.INVALID_MEMBER_PASSWORD_PATTERN)
	String password,

	@NotNull(message = ErrorCode.ClientMessage.INVALID_MEMBER_EMAIL_PATTERN)
	@Email(message = ErrorCode.ClientMessage.INVALID_MEMBER_EMAIL_PATTERN)
	String email
) {
}
