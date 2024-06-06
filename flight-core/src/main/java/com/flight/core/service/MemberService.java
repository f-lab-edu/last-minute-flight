package com.flight.core.service;

import org.springframework.stereotype.Service;

import com.flight.common.dto.SignupRequest;
import com.flight.common.dto.SignupResponse;
import com.flight.common.exception.DuplicatedFieldException;
import com.flight.core.entity.Member;
import com.flight.core.mapper.MemberMapper;
import com.flight.core.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final MemberMapper memberMapper;

	public SignupResponse createAndSaveMember(SignupRequest request) {

		if (loginIdExists(request.loginId())) {
			throw new DuplicatedFieldException("loginId");
		} else if (emailExists(request.email())) {
			throw new DuplicatedFieldException("email");
		} else {
			Member member = memberMapper.requestToEntity(request);
			memberRepository.save(member);

			return memberMapper.entityToResponse(member);
		}
	}

	private boolean loginIdExists(String loginId) {
		return memberRepository.existsByLoginId(loginId);
	}

	private boolean emailExists(String email) {
		return memberRepository.existsByEmail(email);
	}
}
