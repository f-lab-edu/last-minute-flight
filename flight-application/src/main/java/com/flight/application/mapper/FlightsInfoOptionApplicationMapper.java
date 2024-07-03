package com.flight.application.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.flight.application.dto.FlightsInfoOptionApplicationResponse;
import com.flight.core.dto.FlightsInfoOptionDomainResponse;

@Mapper(componentModel = "spring")
public interface FlightsInfoOptionApplicationMapper {

	List<FlightsInfoOptionApplicationResponse> domainResponseToApplicationResponse(
		List<FlightsInfoOptionDomainResponse> domainResponse);

}
