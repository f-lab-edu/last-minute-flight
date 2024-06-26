package com.flight.core.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class BcryptPasswordEncoder implements PasswordEncoder{

	@Override
	public String encrypt(String unencryptedPassword) {
		return BCrypt.hashpw(unencryptedPassword, BCrypt.gensalt());
	}

	@Override
	public boolean matches(String encryptedPassword, String password) {
		return BCrypt.checkpw(password, encryptedPassword);
	}
}
