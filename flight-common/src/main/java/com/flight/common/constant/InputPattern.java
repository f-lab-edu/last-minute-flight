package com.flight.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class InputPattern {

	public static final String MEMBER_NAME_PATTERN = "^[가-힣]{2,10}$";
	public static final String MEMBER_LOGIN_ID_PATTERN = "^[A-Za-z0-9]{5,20}$";
	public static final String MEMBER_PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{5,20}$";
}
