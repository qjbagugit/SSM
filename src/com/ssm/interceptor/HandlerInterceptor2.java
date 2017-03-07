package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class HandlerInterceptor2 implements HandlerInterceptor {

	// 进入handler方法之前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		System.out.println("HandlerInterceptor2.......preHandle");
		return true;
	}

	// 进入handler方法之后，返回ModelAndView之前执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptor2.......postHandle");
	}

	// handler执行完成后执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exception) throws Exception {
		System.out.println("HandlerInterceptor2.......afterCompletion");
	}

}
