package com.flight.core.service;

import org.springframework.stereotype.Service;

import com.flight.common.exception.DuplicatedFieldException;
import com.flight.core.dto.SignupDomainRequest;
import com.flight.core.dto.SignupDomainResponse;
import com.flight.core.entity.Member;
import com.flight.core.mapper.MemberDomainMapper;
import com.flight.core.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final MemberDomainMapper mapper;

	public SignupDomainResponse createAndSaveMember(SignupDomainRequest request) {

		if (loginIdExists(request.loginId())) {
			throw new DuplicatedFieldException("loginId");
		} else if (emailExists(request.email())) {
			throw new DuplicatedFieldException("email");
		} else {
			Member member = mapper.domainRequestToEntity(request);
			memberRepository.save(member);

			return mapper.entityToDomainResponse(member);
		}
	}

	private boolean loginIdExists(String loginId) {
		return memberRepository.existsByLoginId(loginId);
	}

	private boolean emailExists(String email) {
		return memberRepository.existsByEmail(email);
	}
}
