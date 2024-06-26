package com.flight.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.flight.common.dto.SessionInfoThreadLocal;
import com.flight.application.service.MemberApplicationService;
import com.flight.common.dto.MemberSessionInfo;
import com.flight.common.exception.UnAuthenticatedException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

	private final MemberApplicationService memberApplicationService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {

		MemberSessionInfo sessionInfo = memberApplicationService.getSession(
			request.getSession().getId()).orElseThrow(UnAuthenticatedException::new);

		SessionInfoThreadLocal.set(sessionInfo);

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception ex) throws Exception {

		SessionInfoThreadLocal.remove();

		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
}
