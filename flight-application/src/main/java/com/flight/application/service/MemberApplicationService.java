package com.flight.application.service;

import org.springframework.stereotype.Service;

import com.flight.application.dto.SignupServiceRequest;
import com.flight.application.dto.SignupServiceResponse;
import com.flight.application.mapper.MemberApplicationMapper;
import com.flight.core.dto.SignupDomainRequest;
import com.flight.core.dto.SignupDomainResponse;
import com.flight.core.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberApplicationService {

	private final MemberService memberService;
	private final MemberApplicationMapper mapper;

	public SignupServiceResponse signUp(SignupServiceRequest serviceRequest) {

		SignupDomainRequest domainRequest = mapper.serviceRequestToDomainRequest(serviceRequest);

		SignupDomainResponse domainResponse = memberService.createAndSaveMember(domainRequest);

		return mapper.domainResponseToServiceResponse(domainResponse);
	}
}
