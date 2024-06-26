package com.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.application.dto.LoginApplicationRequest;
import com.flight.application.dto.SignupApplicationRequest;
import com.flight.application.dto.SignupApplicationResponse;
import com.flight.application.service.MemberApplicationService;
import com.flight.dto.ApiResponse;
import com.flight.dto.LoginApiRequest;
import com.flight.dto.SignupApiRequest;
import com.flight.dto.SignupApiResponse;
import com.flight.mapper.MemberApiMapper;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberApplicationService memberApplicationService;
	private final MemberApiMapper mapper;

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse<SignupApiResponse>> signup(@RequestBody @Valid SignupApiRequest request) {

		SignupApplicationRequest serviceRequest = mapper.apiRequestToServiceRequest(request);

		SignupApplicationResponse serviceResponse = memberApplicationService.signUp(serviceRequest);

		SignupApiResponse apiResponse = mapper.applicationResponseToApiResponse(serviceResponse);
		ApiResponse<SignupApiResponse> response = ApiResponse.ofSuccess(apiResponse);

		return ResponseEntity.status(HttpStatus.CREATED)
			.body(response);
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<Void>> login(@RequestBody @Valid LoginApiRequest request, HttpSession session) {

		LoginApplicationRequest applicationRequest = mapper.apiRequestToServiceRequest(request);
		memberApplicationService.login(applicationRequest, session.getId());

		ApiResponse<Void> response = ApiResponse.ofSuccess();

		return ResponseEntity.ok(response);
	}

	@PostMapping("/logout")
	public ResponseEntity<ApiResponse<Void>> logout(HttpSession session) {

		memberApplicationService.logout(session.getId());

		ApiResponse<Void> response = ApiResponse.ofSuccess();

		return ResponseEntity.ok(response);
	}
}
