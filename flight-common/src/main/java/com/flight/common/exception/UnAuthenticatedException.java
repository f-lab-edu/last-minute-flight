package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class UnAuthenticatedException extends BadRequestException {

	@Serial
	private static final long serialVersionUID = -491886582039001644L;

	private static final ErrorCode errorCode = ErrorCode.UNAUTHENTICATED;

	public UnAuthenticatedException() {
		super(errorCode, ErrorCode.InternalMessage.UNAUTHENTICATED, ErrorCode.ClientMessage.UNAUTHENTICATED);
	}
}
