package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class DuplicatedFieldException extends BadRequestException {

	@Serial
	private static final long serialVersionUID = 2589213167199844919L;

	private static final ErrorCode errorCode = ErrorCode.DUPLICATED_FIELD;
	private final String fieldName;

	public DuplicatedFieldException(String fieldName) {
		super(errorCode, String.format(ErrorCode.InternalMessage.DUPLICATED_FIELD, fieldName), String.format(ErrorCode.ClientMessage.DUPLICATED_FIELD, fieldName));
		this.fieldName = fieldName;
	}
}
