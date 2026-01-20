package com.idrive.filter;

import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


@Component("rateLimiterFilter")
public class RateLimiterFilter implements Filter {

	protected static final Logger LOG = LoggerFactory.getLogger(RateLimiterFilter.class);
	
	public static final int TOO_MANY_REQUEST_HTTP_CODE = 429;
	
	public static final int DEFAULT_RATE = 50;
	
	private final RateLimiter rateLimiter = RateLimiter.create(DEFAULT_RATE);
	
	private String emailAvailibility = null;		    

	/**
     * Default constructor. 
     */
    public RateLimiterFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
			if (rateLimiter.tryAcquire(0, TimeUnit.MILLISECONDS)) {
				System.out.println("in side fileter :*************");
				chain.doFilter(request, response);
			} else {
				 LOG.warn("RateLimit Reached for the URI "+((HttpServletRequest)request).getRequestURI());
				((HttpServletResponse) response).setStatus(TOO_MANY_REQUEST_HTTP_CODE);
			}

	}

	
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		// fetch the ratelimit from the property file.
		String excludedUrls = fConfig.getInitParameter("excludedUrls");
		System.out.println("Init param exists:"+excludedUrls);

		String rateAsString = "2";
	        if (rateAsString != null && !rateAsString.isEmpty()) {
	            try {
	                double rate = Double.valueOf(rateAsString);
	                LOG.info("Setting rate limit to " + rate);
	                rateLimiter.setRate(rate);
	            } catch (NumberFormatException e) {
	                LOG.error("Invalid rate limit " + rateAsString, e);
	                throw new ServletException();
	            }catch(IllegalArgumentException e){
	            	 LOG.error("Invalid rate limit " + rateAsString, e);
	            }
	        }
	}
	


}
