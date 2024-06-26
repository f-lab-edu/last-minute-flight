package com.flight.core.dto;

import java.time.LocalDateTime;

public record FlightsInfoOptionDomainResponse(
	Long flightsInfoOptionId,
	String departures,
	String arrivals,
	LocalDateTime departureTime,
	LocalDateTime arrivalTime,
	int originalPrice,
	int discountPrice,
	int availableSeats,
	LocalDateTime discountEndTime
) {
}
