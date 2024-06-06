package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public abstract class BadRequestException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -4884378187963789121L;

	private final ErrorCode errorCode;
	private final String clientMessage;

	protected BadRequestException(ErrorCode errorCode, String internalMessage, String clientMessage){
		super(internalMessage);
		this.clientMessage = clientMessage;
		this.errorCode = errorCode;
	}
}
