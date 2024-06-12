package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class PasswordNotMatchException extends BadRequestException {

	@Serial
	private static final long serialVersionUID = -561719815198531430L;

	private static final ErrorCode errorCode = ErrorCode.PASSWORD_NOT_MATCH;

	public PasswordNotMatchException() {
		super(errorCode, ErrorCode.InternalMessage.PASSWORD_NOT_MATCH, ErrorCode.ClientMessage.PASSWORD_NOT_MATCH);
	}
}
