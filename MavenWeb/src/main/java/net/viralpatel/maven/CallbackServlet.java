package net.viralpatel.maven;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CallbackServlet extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final Logger normalLog= LoggerFactory.getLogger(CallbackServlet.class);

	private static final Logger audit_logger= LoggerFactory.getLogger("audit_logger");

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {


	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        audit_logger.info("inside callback servlet audit logger");
		System.out.println(req.getServletPath());
		System.out.println(req.getScheme());
		System.out.println(req.getContextPath());
		System.out.println(req.getQueryString());


		System.out.println("request "+req.getParameter("isInternal"));
		System.out.println("user is:"+req.getParameter("user"));
        normalLog.debug("with noraml log");

		resp.getWriter().write("Sucessfully served request");


	}


}
