package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class InsufficientSeatsException extends UncheckedException {

	@Serial
	private static final long serialVersionUID = 7682304117968186623L;

	private static final ErrorCode errorCode = ErrorCode.INSUFFICIENT_SEATS;
	private final Long flightInfoOptionId;

	public InsufficientSeatsException(Long flightInfoOptionId) {
		super(errorCode, String.format(ErrorCode.InternalMessage.INSUFFICIENT_SEATS, flightInfoOptionId), ErrorCode.ClientMessage.INSUFFICIENT_SEATS);
		this.flightInfoOptionId = flightInfoOptionId;
	}
}
