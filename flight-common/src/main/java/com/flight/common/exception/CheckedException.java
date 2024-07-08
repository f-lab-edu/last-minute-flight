package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public abstract class CheckedException extends Exception {

	@Serial
	private static final long serialVersionUID = 968917053243336600L;

	private final ErrorCode errorCode;
	private final String clientMessage;

	protected CheckedException(ErrorCode errorCode, String internalMessage, String clientMessage){
		super(internalMessage);
		this.clientMessage = clientMessage;
		this.errorCode = errorCode;
	}
}
