package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public abstract class UncheckedException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = -6084520605815272357L;

	private final ErrorCode errorCode;
	private final String clientMessage;

	protected UncheckedException(ErrorCode errorCode, String internalMessage, String clientMessage) {
		super(internalMessage);
		this.errorCode = errorCode;
		this.clientMessage = clientMessage;
	}

	protected UncheckedException(ErrorCode errorCode, String internalMessage, String clientMessage, Throwable cause) {
		super(internalMessage, cause);
		this.errorCode = errorCode;
		this.clientMessage = clientMessage;
	}
}
