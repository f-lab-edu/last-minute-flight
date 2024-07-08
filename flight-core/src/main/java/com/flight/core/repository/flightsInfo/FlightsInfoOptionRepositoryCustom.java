package com.flight.core.repository.flightsInfo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.flight.core.dto.FlightsInfoOptionDomainResponse;

public interface FlightsInfoOptionRepositoryCustom {

	List<FlightsInfoOptionDomainResponse> search(String departures, String arrivals, LocalDate departureDate);

	Optional<FlightsInfoOptionDomainResponse> findFlightsInfoById(Long flightsInfoOptionId);
}
