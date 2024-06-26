package com.flight.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

	// client
	DUPLICATED_FIELD("C000", 400),
	INVALID_INPUT_PATTERN("C001", 400),
	RESOURCE_NOT_FOUND("C002", 400),
	PASSWORD_NOT_MATCH("C003", 401),
	UNAUTHENTICATED("C004", 401);

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
		public static final String EMPTY_MEMBER_LOGIN_ID = "Login ID must not be empty";
		public static final String EMPTY_MEMBER_LOGIN_PASSWORD = "Login Password must not be empty";
		public static final String RESOURCE_NOT_FOUND = "%s not found";
		public static final String PASSWORD_NOT_MATCH = "Password not match";
		public static final String UNAUTHENTICATED = "Member is not authenticated";
	}

	public abstract static class InternalMessage {

		private InternalMessage(){}

		public static final String DUPLICATED_FIELD = "Duplicated Field : [%s]";
		public static final String INVALID_INPUT_PATTERN = "Invalid Pattern / Field : [%s]";
		public static final String RESOURCE_NOT_FOUND = "Resource not found : [%s]";
		public static final String PASSWORD_NOT_MATCH = "Password not match";
		public static final String UNAUTHENTICATED = "Member is not authenticated";

	}
}
