package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
@Path("/demo")
public class DemoResource {

	@Context HttpServletRequest httpServletRequest;
	
	@Produces
	@Consumes
	@GET
	@Path("/service")
	public String respond() {
		DemoUser demoUser= new DemoUser();
		demoUser.setUserId(String.valueOf(Math.random()));
		DemoThreadLocal.setContext(demoUser);
		System.out.println("User of the request: "+DemoThreadLocal.getContext().getUserId());
		return "first test response@@@@@@@@@%%%%%%%";
	}

	

}
