package com.flight.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.application.dto.TestCreateRequest;
import com.flight.application.dto.TestCreateResponse;
import com.flight.application.dto.TestReadResponse;
import com.flight.application.service.TestService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TestController {

	private final TestService testService;

	@PostMapping("/tests")
	public ResponseEntity<TestCreateResponse> create(@RequestBody TestCreateRequest createRequest) {

		TestCreateResponse response = testService.createTest(createRequest);

		return ResponseEntity.status(HttpStatus.CREATED)
			.body(response);
	}

	@GetMapping("/tests")
	public ResponseEntity<List<TestReadResponse>> readAll(){

		List<TestReadResponse> response = testService.readAllTest();

		return ResponseEntity.status(HttpStatus.OK)
			.body(response);
	}
}
