package com.idrive.server.resources;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.idrive.bean.Stock;

import sun.misc.BASE64Decoder;




/**
 * @author Test
 * 
 * 
 *  The login-config tag inside web.xml enables basic authentication for that application.  this tag makes the pop up appear during the first request. Remove this tag, popup will not appear anymore
    In basic authentication, with every request user id and password are encoded using BASE64 algorithm sent in the http header as "Authorization:Basic YWRtaW46YWRtaW4=" 
    It is like, every time we send user id and password with every request. so there is no session concept here.

    Restful web services are state less. subsequent requests do not depend upon previous requests.

    stateful: subsequent requests depend on previous requests. i.e during the first request session object is created and stored on server and the same is sent to the client.

   With SSL enabled and Basic authentication
   The Base64Encoding still happens but inside encrypted secure channel. So it is very difficult to middle-man to decrypt the same.

   Encoded values can be decoded very esaily to plain text.
   But through secure channel, its not possible 



 *
 */
@Component // this is very much required to inject spring beans into jersey resources
@Path("/api")
public class Myservice {

	private static final Logger log= Logger.getLogger(Myservice.class);
	@Autowired
	Stock myStock;

	public void setMyStock(Stock myStock) {
		this.myStock = myStock;
	}

	@GET
	@Path("/stock/price")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response getStockPrice(@HeaderParam(value = "Authorization") String authParam) {
		try {
			System.out.println("inside geting stock price************");
			//Thread.sleep(5000);
			//if(isUserAuthenticated(authParam))
			myStock.setStockName("IBM");
			//myStock.setStockPrice("200");
			myStock.setStrockCountry("");
			log.debug("waiting for the stock price");
			System.out.println("waiting for the stock price");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("exception occurred", e);
		}
		return Response.ok().entity(myStock).build();
	}
	/*@GET
	@Path("/image")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM })
	public void getImage() {
		File f=null;
        try {
			Thread.sleep(5000);
			log.debug("waiting for the stock Image");
			f= new File("/usr/share/apache-tomcat-6.0.41/webapps/myservice/images.jpg");
			try {
				BufferedInputStream bis= new BufferedInputStream(new FileInputStream(f));
				ByteArrayOutputStream baos=new ByteArrayOutputStream();
				BufferedOutputStream bos= new BufferedOutputStream(baos);
				int i=0;
				while((i=bis.read())!=-1){
					bos.write(i);
				}
				bos.flush();
				bis.close();
				bos.close();
			} catch (FileNotFoundException e) {
				log.error("Exception", e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				log.error("Exception", e);
			}
			System.out.println("waiting for the stock price");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.error("Exception", e);
		}
		return ;
	}*/

	private boolean isUserAuthenticated(String authString){

		String decodedAuth = "";
		// Header is in the format "Basic 5tyc0uiDat4"
		// We need to extract data before decoding it back to original string
		String[] authParts = authString.split("\\s+");
		String authInfo = authParts[1];
		// Decode the data back to original string
		byte[] bytes = null;
		try {
			bytes = new BASE64Decoder().decodeBuffer(authInfo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		decodedAuth = new String(bytes);
		log.debug("Decoded authentication: "+decodedAuth);

		/**
		 * here you include your logic to validate user authentication.
		 * it can be using ldap, or token exchange mechanism or your
		 * custom authentication mechanism.
		 */
		// your validation code goes here....

		return true;
	}


	@POST
	@Path("{id}/inmessage")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,MediaType.TEXT_HTML })
	public String outMessageFromTwilio( MultivaluedMap<String, String> formParams, @Context HttpServletRequest request ) {
		
		log.info("query string from request:  *******: "+request.getQueryString());
		
		String message = formParams.getFirst("Body");
		String From = formParams.getFirst("From");
		String To = formParams.getFirst("To");
		String messageSID = formParams.getFirst("MessageSid");
		String messageServiceSID = formParams.getFirst("MessagingServiceSid");

		log.info("message: " + message);
		log.info("From: " + From);
		log.info("To: " + To);
		log.info("messageSID: " + messageSID);
		log.info("messageServiceSID: " + messageServiceSID);

		return "SUCCESS";

	}


	/**
	 * 
	 * Multivalued map accepts values only from request body not from query params
	 * FormParam accepts data either from query param or request body
	 * 
	 * MultivaluedMap is the one which differentiates quey and formdata
	 * 
	 * @param from
	 * @return
	 */
	@POST
	@Path("/inmsg")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON,MediaType.TEXT_HTML })
	public String createInMessage(@FormParam("from") String from) {
		log.info("From: " + from);
		return "SUCCESS";

	}


	@GET
	@Path("/")
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response serveRequest(@QueryParam("status") int status) {
		System.out.println("inside serving the home request***************");
		return Response.ok().entity(myStock).build();
	}


}



