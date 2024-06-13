package com.flight.core.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flight.common.exception.DuplicatedFieldException;
import com.flight.core.dto.MemberDomainResponse;
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

		throwExceptionIfEmailExists(request.email());
		throwExceptionIfLoginIdExists(request.loginId());

		Member member = mapper.domainRequestToEntity(request);
		memberRepository.save(member);

		return mapper.entityToSignupDomainResponse(member);

	}

	public Optional<MemberDomainResponse> getMemberByLoginId(String loginId) {

		Optional<Member> optionalMember = memberRepository.findByLoginId(loginId);
		return optionalMember.map(mapper::entityToDomainResponse);
	}

	private void throwExceptionIfLoginIdExists(String loginId) {

		if (memberRepository.existsByLoginId(loginId)) {
			throw new DuplicatedFieldException("loginId");
		}
	}

	private void throwExceptionIfEmailExists(String email) {

		if (memberRepository.existsByEmail(email)) {
			throw new DuplicatedFieldException("email");
		}
	}
}
