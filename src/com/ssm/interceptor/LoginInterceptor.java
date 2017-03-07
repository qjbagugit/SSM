package com.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	// 进入handler方法之前执行
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		String uri = request.getRequestURI();
		// 判断是否为公开地址(不需要进行拦截的地址)
		if(uri.indexOf("login.action")>0){
			return true;
		}
		// 判断session，校验用户是否登录
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if(username!=null && username.length()>0){
			return true;
		}
		// 用户未登录，跳到登录界面
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}

	// 进入handler方法之后，返回ModelAndView之前执行
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj,
			ModelAndView modelAndView) throws Exception {
	}

	// handler执行完成后执行
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception exception) throws Exception {
	}

}
