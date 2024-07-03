package com.flight.core.dto;

import java.time.LocalDateTime;

public record FlightsInfoDomainResponse(
	String departures,
	String arrivals,
	LocalDateTime departureTime,
	LocalDateTime arrivalTime
) {
}
