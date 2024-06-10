package com.flight.application.mapper;

import org.mapstruct.Mapper;

import com.flight.application.dto.SignupServiceRequest;
import com.flight.application.dto.SignupServiceResponse;
import com.flight.core.dto.SignupDomainRequest;
import com.flight.core.dto.SignupDomainResponse;

@Mapper(componentModel = "spring")
public interface MemberApplicationMapper {

	SignupDomainRequest serviceRequestToDomainRequest(SignupServiceRequest serviceRequest);
	SignupServiceResponse domainResponseToServiceResponse(SignupDomainResponse domainResponse);
}
