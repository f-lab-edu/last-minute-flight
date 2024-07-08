package com.flight.application.dto;

public record BookingApplicationRequest(
	Long flightsInfoOptionId,
	int headCount
) {
}
