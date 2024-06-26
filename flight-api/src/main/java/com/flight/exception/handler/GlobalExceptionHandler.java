package com.flight.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.flight.common.exception.BadRequestException;
import com.flight.common.exception.ErrorCode;
import com.flight.dto.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ApiResponse<Void>> badRequestException(BadRequestException e) {

		ErrorCode errorCode = e.getErrorCode();
		ApiResponse<Void> response = ApiResponse.ofFail(errorCode.getCode(), e.getClientMessage());

		return ResponseEntity.status(errorCode.getHttpStatusCode())
			.body(response);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiResponse<Void>> methodArgumentNotValidException(MethodArgumentNotValidException e) {

		ErrorCode errorCode = ErrorCode.INVALID_INPUT_PATTERN;
		String clientMessage = e.getAllErrors().get(0).getDefaultMessage();
		ApiResponse<Void> response = ApiResponse.ofFail(errorCode.getCode(), clientMessage);

		return ResponseEntity.status(errorCode.getHttpStatusCode())
			.body(response);
	}
}
