package com.flight.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.flight.application.dto.FlightsInfoOptionApplicationResponse;
import com.flight.dto.FlightsInfoOptionApiResponse;

@Mapper(componentModel = "spring")
public interface FlightsInfoOptionApiMapper {

	List<FlightsInfoOptionApiResponse> applicationResponseToApiResponse(
		List<FlightsInfoOptionApplicationResponse> domainResponse);

}
