package com.flight.core.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.RequiredArgsConstructor;

@Converter
@RequiredArgsConstructor
public class PasswordConverter implements AttributeConverter<String ,String> {

	private final PasswordEncoder passwordEncoder;

	@Override
	public String convertToDatabaseColumn(String unencryptedPassword) {
		return passwordEncoder.encrypt(unencryptedPassword);
	}

	@Override
	public String convertToEntityAttribute(String encryptedPassword) {
		return encryptedPassword;
	}
}
