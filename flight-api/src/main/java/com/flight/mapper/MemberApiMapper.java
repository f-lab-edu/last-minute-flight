package com.flight.mapper;

import org.mapstruct.Mapper;

import com.flight.application.dto.LoginApplicationRequest;
import com.flight.application.dto.SignupApplicationRequest;
import com.flight.application.dto.SignupApplicationResponse;
import com.flight.dto.LoginApiRequest;
import com.flight.dto.SignupApiRequest;
import com.flight.dto.SignupApiResponse;

@Mapper(componentModel = "spring")
public interface MemberApiMapper {

	SignupApplicationRequest apiRequestToServiceRequest(SignupApiRequest apiRequest);
	SignupApiResponse applicationResponseToApiResponse(SignupApplicationResponse serviceResponse);
	LoginApplicationRequest apiRequestToServiceRequest(LoginApiRequest apiRequest);
}
