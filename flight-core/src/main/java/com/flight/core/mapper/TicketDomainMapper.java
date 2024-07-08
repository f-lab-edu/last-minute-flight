package com.flight.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flight.core.dto.TicketCreateDomainRequest;
import com.flight.core.entity.Ticket;

@Mapper(componentModel = "spring")
public interface TicketDomainMapper {

	@Mapping(source = "ticketNumber", target = "ticketNumber")
	Ticket domainRequestToEntity(TicketCreateDomainRequest request, String ticketNumber);
}
