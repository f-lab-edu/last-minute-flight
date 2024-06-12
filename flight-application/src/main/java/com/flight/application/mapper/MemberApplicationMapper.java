package com.flight.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.flight.application.dto.SignupApplicationRequest;
import com.flight.application.dto.SignupApplicationResponse;
import com.flight.common.dto.MemberSessionInfo;
import com.flight.core.dto.MemberDomainResponse;
import com.flight.core.dto.SignupDomainRequest;
import com.flight.core.dto.SignupDomainResponse;

@Mapper(componentModel = "spring")
public interface MemberApplicationMapper {

	SignupDomainRequest serviceRequestToDomainRequest(SignupApplicationRequest serviceRequest);

	SignupApplicationResponse domainResponseToApplicationResponse(SignupDomainResponse domainResponse);

	@Mapping(source = "domainResponse.name", target = "name")
	@Mapping(source = "domainResponse.loginId", target = "loginId")
	@Mapping(source = "domainResponse.email", target = "email")
	@Mapping(source = "sessionId", target = "sessionId")
	MemberSessionInfo domainResponseToDto(MemberDomainResponse domainResponse, String sessionId);
}
