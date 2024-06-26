package com.flight.core.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.flight.common.dto.MemberSessionInfo;
import com.flight.core.entity.MemberSession;
import com.flight.core.mapper.MemberSessionDomainMapper;
import com.flight.core.repository.MemberSessionCache;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberSessionService {

	private final MemberSessionCache memberSessionCache;
	private final MemberSessionDomainMapper mapper;

	public void createAndSaveSession(MemberSessionInfo sessionInfo) {

		MemberSession memberSession = mapper.dtoToEntity(sessionInfo);

		memberSessionCache.saveSession(memberSession);
	}

	public Optional<MemberSessionInfo> getSession(String sessionId) {

		Optional<MemberSession> optionalMemberSession = memberSessionCache.findSession(sessionId);

		return optionalMemberSession.map(mapper::entityToDto);
	}

	public void deleteSession(String sessionId) {
		memberSessionCache.deleteSession(sessionId);
	}
}
