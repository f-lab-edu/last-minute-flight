package com.flight.mapper;

import org.mapstruct.Mapper;

import com.flight.application.dto.SignupServiceRequest;
import com.flight.application.dto.SignupServiceResponse;
import com.flight.dto.SignupApiRequest;
import com.flight.dto.SignupApiResponse;

@Mapper(componentModel = "spring")
public interface MemberApiMapper {

	SignupServiceRequest apiRequestToServiceRequest(SignupApiRequest apiRequest);
	SignupApiResponse serviceResponseToApiResponse(SignupServiceResponse serviceResponse);
}
