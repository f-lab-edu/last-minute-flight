package com.flight.application.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flight.application.dto.LoginApplicationRequest;
import com.flight.application.dto.SignupApplicationRequest;
import com.flight.application.dto.SignupApplicationResponse;
import com.flight.application.mapper.MemberApplicationMapper;
import com.flight.common.dto.MemberSessionInfo;
import com.flight.common.exception.PasswordNotMatchException;
import com.flight.common.exception.ResourceNotFoundException;
import com.flight.core.dto.MemberDomainResponse;
import com.flight.core.dto.SignupDomainRequest;
import com.flight.core.dto.SignupDomainResponse;
import com.flight.core.service.MemberService;
import com.flight.core.service.MemberSessionService;
import com.flight.core.util.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberApplicationService {

	private final MemberService memberService;
	private final MemberSessionService memberSessionService;
	private final MemberApplicationMapper mapper;
	private final PasswordEncoder passwordEncoder;

	public SignupApplicationResponse signUp(SignupApplicationRequest serviceRequest) {

		SignupDomainRequest domainRequest = mapper.serviceRequestToDomainRequest(serviceRequest);

		SignupDomainResponse domainResponse = memberService.createAndSaveMember(domainRequest);

		return mapper.domainResponseToApplicationResponse(domainResponse);
	}

	public void login(LoginApplicationRequest applicationRequest, String sessionId) {

		MemberDomainResponse domainResponse = memberService.getMemberByLoginId(applicationRequest.loginId()).orElseThrow(
			() -> new ResourceNotFoundException("member")
		);

		if(!passwordEncoder.matches(domainResponse.password(), applicationRequest.password())){
			throw new PasswordNotMatchException();
		}

		MemberSessionInfo sessionInfo = mapper.domainResponseToDto(domainResponse, sessionId);

		memberSessionService.createAndSaveSession(sessionInfo);
	}

	public void logout(String sessionId) {

		memberSessionService.deleteSession(sessionId);
	}

	public Optional<MemberSessionInfo> getSession(String sessionId) {

		return memberSessionService.getSession(sessionId);
	}
}
