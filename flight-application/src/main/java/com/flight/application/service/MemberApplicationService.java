package com.flight.application.service;

import org.springframework.stereotype.Service;

import com.flight.common.dto.SignupRequest;
import com.flight.common.dto.SignupResponse;
import com.flight.core.service.MemberService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberApplicationService {

	private final MemberService memberService;

	public SignupResponse signUp(SignupRequest request) {

		return memberService.createAndSaveMember(request);
	}
}
