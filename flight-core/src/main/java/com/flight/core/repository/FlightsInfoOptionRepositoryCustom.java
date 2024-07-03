package com.flight.core.repository;

import java.time.LocalDate;
import java.util.List;

import com.flight.core.dto.FlightsInfoOptionDomainResponse;

public interface FlightsInfoOptionRepositoryCustom {

	List<FlightsInfoOptionDomainResponse> search(String departures, String arrivals, LocalDate departureDate);

}
