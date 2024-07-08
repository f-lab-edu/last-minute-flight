package com.flight.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flight.application.dto.BookingApplicationRequest;
import com.flight.dto.BookingApiRequest;

@Mapper(componentModel = "spring")
public interface BookingApiMapper {

	@Mapping(source = "flightsInfoOptionId", target = "flightsInfoOptionId")
	@Mapping(source = "apiRequest.headCount", target = "headCount")
	BookingApplicationRequest bookingApiRequestToBookingApplicationRequest(Long flightsInfoOptionId, BookingApiRequest apiRequest);
}
