package com.flight.common.exception;

import java.io.Serial;

import lombok.Getter;

@Getter
public class LockAcquisitionFailException extends CheckedException {

	@Serial
	private static final long serialVersionUID = 2751643675194548206L;

	private static final ErrorCode errorCode = ErrorCode.LOCK_ACQUISITION_FAILED;
	private final String lockKey;

	public LockAcquisitionFailException(String lockKey) {
		super(errorCode, String.format(ErrorCode.InternalMessage.LOCK_ACQUISITION_FAILED, lockKey),
			ErrorCode.ClientMessage.INTERNAL_SERVER_ERROR);
		this.lockKey = lockKey;
	}

}
