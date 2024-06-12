package com.flight.core.repository;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.flight.core.entity.MemberSession;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberSessionRepository {

	private static final String SESSION_PREFIX = "session_";
	private static final long TIME_OUT_MINUTE = 60;
	private final RedisTemplate<String, Object> redisTemplate;

	public void saveSession(MemberSession sessionData) {
		String sessionKey = getSessionKey(sessionData.sessionId());
		redisTemplate.opsForValue().set(sessionKey, sessionData);
		updateTTL(sessionKey);
	}

	public Optional<MemberSession> findSession(String sessionId) {
		String sessionKey = getSessionKey(sessionId);
		updateTTL(sessionKey);

		return Optional.ofNullable((MemberSession)redisTemplate.opsForValue().get(sessionKey));
	}

	public void deleteSession(String sessionId) {
		redisTemplate.delete(getSessionKey(sessionId));
	}

	private void updateTTL(String key) {

		redisTemplate.expire(key, TIME_OUT_MINUTE, TimeUnit.MINUTES);
	}

	private String getSessionKey(String sessionId) {

		return SESSION_PREFIX + sessionId;
	}
}
