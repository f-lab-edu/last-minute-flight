package com.flight.core.entity;

import java.io.Serial;
import java.io.Serializable;

public record MemberSession(
	String sessionId,
	String name,
	String loginId,
	String email
) implements Serializable {

	@Serial
	private static final long serialVersionUID = 8916142245051532388L;
}
