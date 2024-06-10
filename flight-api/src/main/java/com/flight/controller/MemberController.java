package com.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.application.dto.SignupServiceRequest;
import com.flight.application.dto.SignupServiceResponse;
import com.flight.application.service.MemberApplicationService;
import com.flight.dto.ApiResponse;
import com.flight.dto.SignupApiRequest;
import com.flight.dto.SignupApiResponse;
import com.flight.mapper.MemberApiMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberApplicationService memberApplicationService;
	private final MemberApiMapper mapper;

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse<SignupApiResponse>> signup(@RequestBody @Valid SignupApiRequest request) {

		SignupServiceRequest serviceRequest = mapper.apiRequestToServiceRequest(request);

		SignupServiceResponse serviceResponse = memberApplicationService.signUp(serviceRequest);

		SignupApiResponse apiResponse = mapper.serviceResponseToApiResponse(serviceResponse);
		ApiResponse<SignupApiResponse> response = ApiResponse.ofSuccess(apiResponse);

		return ResponseEntity.status(HttpStatus.CREATED)
			.body(response);
	}
}
