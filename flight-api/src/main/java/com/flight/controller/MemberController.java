package com.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.application.service.MemberApplicationService;
import com.flight.common.dto.SignupRequest;
import com.flight.common.dto.SignupResponse;
import com.flight.dto.ApiResponse;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberApplicationService memberApplicationService;

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse<SignupResponse>> signup(@RequestBody @Valid SignupRequest request) {

		SignupResponse response = memberApplicationService.signUp(request);
		ApiResponse<SignupResponse> apiResponse = ApiResponse.ofSuccess(response);

		return ResponseEntity.status(HttpStatus.CREATED)
			.body(apiResponse);
	}
}
