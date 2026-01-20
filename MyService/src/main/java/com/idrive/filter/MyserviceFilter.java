package com.idrive.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;

public class MyserviceFilter implements Filter{

	private static final Logger log= Logger.getLogger(MyserviceFilter.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		//String from=arg0.getParameter("From");
		//HttpServletRequestWrapper wrapper = new HttpServletRequestWrapper((HttpServletRequest) arg0);
		/*Map<String, String[]> requestMap= new HashMap<String, String[]>();
		requestMap.put("From", arg0.getParameterValues("From"));*/
		
		//Map<String, String> requestMap=wrapper.getParameterMap();
		//requestMap.put("From", arg0.getParameter("From"));
		//log.info("from in filter"+from);
		arg2.doFilter(arg0, arg1);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
