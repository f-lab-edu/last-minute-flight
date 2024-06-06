package com.flight.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

	// client
	DUPLICATED_FIELD("C000", 400),
	INVALID_INPUT_PATTERN("C001", 400);

	private final String code;
	private final int httpStatusCode;

	ErrorCode(String code, int httpStatusCode) {
		this.code = code;
		this.httpStatusCode = httpStatusCode;
	}

	public abstract static class ClientMessage {
		
		private ClientMessage(){}

		public static final String DUPLICATED_FIELD = "Field %s is duplicated";
		public static final String INVALID_MEMBER_LOGIN_ID_PATTERN = "Login ID must be between 5 and 20 characters long and consist of Korean, English letters, and numbers.";
		public static final String INVALID_MEMBER_NAME_PATTERN = "Name must be between 2 and 10 characters long and consist of Korean characters.";
		public static final String INVALID_MEMBER_PASSWORD_PATTERN = "Password must be between 5 and 20 characters long and contain at least one Korean character, one English letter, and one number.";
		public static final String INVALID_MEMBER_EMAIL_PATTERN = "Email must be in email format.";
	}

	public abstract static class InternalMessage {

		private InternalMessage(){}

		public static final String DUPLICATED_FIELD = "Duplicated Field : [%s]";
		public static final String INVALID_INPUT_PATTERN = "Invalid Pattern / Field : [%s]";
	}
}
