package com.flight.application.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.application.dto.FlightsInfoOptionApplicationResponse;
import com.flight.application.mapper.FlightsInfoOptionApplicationMapper;
import com.flight.core.dto.FlightsInfoOptionDomainResponse;
import com.flight.core.service.FlightsInfoOptionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightsInfoOptionApplicationService {

	private final FlightsInfoOptionService flightsInfoOptionService;
	private final FlightsInfoOptionApplicationMapper mapper;

	public List<FlightsInfoOptionApplicationResponse> searchFlightsInfoOptions(String departures, String arrivals,
		LocalDate departureDate) {

		List<FlightsInfoOptionDomainResponse> domainResponses = flightsInfoOptionService.search(departures, arrivals,
			departureDate);

		return mapper.domainResponseToApplicationResponse(domainResponses);
	}

}
