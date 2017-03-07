package com.ssm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception ex) {
		ex.printStackTrace();
		CustomException customException = null;
		if(ex instanceof CustomException){
			customException = (CustomException) ex;
		}else{
			customException = new CustomException("未知错误，请与系统管理 员联系！");
		}
		ModelAndView model = new ModelAndView();
		model.addObject("message", customException.getMessage());
		model.setViewName("error");
		return model;
	}
}
