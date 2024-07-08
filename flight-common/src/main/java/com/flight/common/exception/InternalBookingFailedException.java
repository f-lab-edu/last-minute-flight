package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class InternalBookingFailedException extends UncheckedException {

	@Serial
	private static final long serialVersionUID = 8777757393176868752L;

	private static final ErrorCode errorCode = ErrorCode.INTERNAL_BOOKING_FAILED;

	public InternalBookingFailedException(Throwable e) {
		super(errorCode, e.getMessage(), ErrorCode.ClientMessage.INTERNAL_BOOKING_FAILED, e);
	}

}
