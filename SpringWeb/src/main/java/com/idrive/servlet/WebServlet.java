package com.idrive.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.idrive.util.SpringContextUtil;

public class WebServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet{
	
	ReloadableResourceBundleMessageSource messageSource;

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		
		messageSource=(ReloadableResourceBundleMessageSource)SpringContextUtil.getApplicationContext().getBean("messageSource");
		System.out.println("message source:  "+messageSource+" :   locale is:  "+LocaleContextHolder.getLocale());
		System.out.println("servlet:  "+RequestContextUtils.getLocale(request));
		
		
	}

}
