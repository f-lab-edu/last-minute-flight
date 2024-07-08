package com.flight.core.dto;

public record TicketCreateDomainRequest(
	Long flightsInfoOptionId,
	Long bookingId,
	int originalPrice,
	int discountPrice,
	int headCount
) {
}
