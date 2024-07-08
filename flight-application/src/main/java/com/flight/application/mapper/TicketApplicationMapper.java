package com.flight.application.mapper;

import org.mapstruct.Mapper;

import com.flight.core.dto.TicketCreateDomainRequest;

@Mapper(componentModel = "spring")
public interface TicketApplicationMapper {

	TicketCreateDomainRequest toTicketCreateDomainRequest(Long flightsInfoOptionId, Long bookingId, int originalPrice, int discountPrice, int headCount);
}
