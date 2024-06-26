package com.flight.core.util;

public interface PasswordEncoder {

	String encrypt(String unencryptedPassword);
	boolean matches(String encryptedPassword, String password);
}
