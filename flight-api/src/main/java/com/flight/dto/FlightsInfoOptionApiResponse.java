package com.flight.dto;

import java.time.LocalDateTime;

public record FlightsInfoOptionApiResponse(
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
