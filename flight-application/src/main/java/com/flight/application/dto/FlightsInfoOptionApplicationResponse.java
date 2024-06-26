package com.flight.application.dto;

import java.time.LocalDateTime;

public record FlightsInfoOptionApplicationResponse(
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
