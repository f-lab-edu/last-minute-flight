package com.flight.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flight.application.dto.FlightsInfoOptionApplicationResponse;
import com.flight.application.service.FlightsInfoOptionApplicationService;
import com.flight.dto.ApiResponse;
import com.flight.dto.FlightsInfoOptionApiResponse;
import com.flight.mapper.FlightsInfoOptionApiMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FlightsInfoOptionController {

	private final FlightsInfoOptionApplicationService flightsInfoOptionApplicationService;
	private final FlightsInfoOptionApiMapper mapper;

	@GetMapping("/flightsInfo")
	public ResponseEntity<ApiResponse<List<FlightsInfoOptionApiResponse>>> searchFlightsInfoOption(
		@RequestParam("departures") String departures,
		@RequestParam("arrivals") String arrivals,
		@RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate
	) {

		List<FlightsInfoOptionApplicationResponse> applicationResponses = flightsInfoOptionApplicationService.searchFlightsInfoOptions(
			departures, arrivals, departureDate);

		List<FlightsInfoOptionApiResponse> apiResponses = mapper.applicationResponseToApiResponse(
			applicationResponses);

		ApiResponse<List<FlightsInfoOptionApiResponse>> response = ApiResponse.ofSuccess(apiResponses);

		return ResponseEntity.ok(response);
	}
}
