package com.flight.core.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.flight.core.dto.FlightsInfoOptionDomainResponse;
import com.flight.core.repository.FlightsInfoOptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FlightsInfoOptionService {

	private final FlightsInfoOptionRepository flightsInfoOptionRepository;

	public List<FlightsInfoOptionDomainResponse> search(String departures, String arrivals, LocalDate departureDate) {

		return flightsInfoOptionRepository.search(departures, arrivals, departureDate);
	}
}
