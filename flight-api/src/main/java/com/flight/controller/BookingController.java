package com.flight.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flight.application.service.BookingApplicationService;
import com.flight.dto.ApiResponse;
import com.flight.dto.BookingApiRequest;
import com.flight.mapper.BookingApiMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

	private final BookingApplicationService bookingApplicationService;
	private final BookingApiMapper mapper;

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/flightsInfo/{flightsInfoOptionId}")
	public ApiResponse<Void> book(@PathVariable Long flightsInfoOptionId, @RequestBody @Valid BookingApiRequest apiRequest) {

		bookingApplicationService.book(mapper.bookingApiRequestToBookingApplicationRequest(flightsInfoOptionId, apiRequest));

		return ApiResponse.ofSuccess();
	}
}
