package com.flight.core.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flight.common.dto.MemberSessionInfo;
import com.flight.core.entity.MemberSession;
import com.flight.core.mapper.MemberSessionDomainMapper;
import com.flight.core.repository.MemberSessionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberSessionService {

	private final MemberSessionRepository memberSessionRepository;
	private final MemberSessionDomainMapper mapper;

	public void createAndSaveSession(MemberSessionInfo sessionInfo) {

		MemberSession memberSession = mapper.dtoToEntity(sessionInfo);

		memberSessionRepository.saveSession(memberSession);
	}

	public Optional<MemberSessionInfo> getSession(String sessionId) {

		Optional<MemberSession> optionalMemberSession = memberSessionRepository.findSession(sessionId);

		return optionalMemberSession.map(mapper::entityToDto);
	}

	public void deleteSession(String sessionId) {
		memberSessionRepository.deleteSession(sessionId);
	}
}
