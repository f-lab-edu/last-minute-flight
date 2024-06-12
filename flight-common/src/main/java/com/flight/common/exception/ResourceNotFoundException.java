package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class ResourceNotFoundException extends BadRequestException {

	@Serial
	private static final long serialVersionUID = -8914858245057337388L;

	private static final ErrorCode errorCode = ErrorCode.RESOURCE_NOT_FOUND;
	private final String resourceName;

	public ResourceNotFoundException(String resourceName) {
		super(errorCode, String.format(ErrorCode.InternalMessage.RESOURCE_NOT_FOUND, resourceName), String.format(ErrorCode.ClientMessage.RESOURCE_NOT_FOUND, resourceName));
		this.resourceName = resourceName;
	}
}
