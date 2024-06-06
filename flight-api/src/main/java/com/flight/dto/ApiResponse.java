package com.flight.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiResponse<T> {

	private boolean success;
	private T data;
	private String errorCode;
	private String errorMsg;

	public static <T> ApiResponse<T> ofSuccess(T data) {
		return new ApiResponse<>(true, data, null, null);
	}

	public static ApiResponse<Void> ofSuccess() {
		return new ApiResponse<>(true, null, null, null);
	}

	public static ApiResponse<Void> ofFail(String errorCode, String message) {
		return new ApiResponse<>(false, null, errorCode, message);
	}
}
