package com.flight.core.util;

import java.util.Random;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TicketNumberGenerator {

	private static final Random random = new Random();
	private static final long MIN = 1_000_000_000_000L;
	private static final long MAX = 9_999_999_999_999L;

	public static String generate() {

		return String.valueOf(MIN + (long)(random.nextDouble() * (MAX - MIN)));
	}
}
