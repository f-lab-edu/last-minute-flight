package com.flight.common.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessionInfoThreadLocal {

	private static final ThreadLocal<MemberSessionInfo> SESSION_INFO_THREAD_LOCAL = new ThreadLocal<>();

	public static void set(MemberSessionInfo loginMemberInfo){
		SESSION_INFO_THREAD_LOCAL.set(loginMemberInfo);
	}

	public static void remove() {
		SESSION_INFO_THREAD_LOCAL.remove();
	}

	public static MemberSessionInfo get(){
		return SESSION_INFO_THREAD_LOCAL.get();
	}
}
