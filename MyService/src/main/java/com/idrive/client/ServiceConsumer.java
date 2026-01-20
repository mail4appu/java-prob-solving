package com.idrive.client;

/**
 * @author Test
 * In the sequential programming, one statment should be finished to go to next statement.
 * 
 * Above statement looks very simple, but it has larger point hidden in it.
 * 
 * for example, lets say, there is a statement which calls a webserivice.
 * 
 * here statement should be finished means, not just triggering the web service request but also waiting till the webservice gives the response
 * irrespetive of whether you print the response or not
 * 
 * i.e statement finished ==> run time finish of the statement.
 * i.e request triggering statement is said to be finished,  only when it gets the response. Then only control goes to next statment
 * 
 *  
 *  Requirement:
 *  
 *  Here you dont want to wait till the request triggering statement is finished.
 *  
 *  suppose line 58 is a webservice call
 *  
 *  and  line no 59 should be executed irrespetive of the line no 58 is finished  or not.
 *  
 *  How to achieve this?
 *  
 *  lines 58 and 59 should be executed independently and parallelly
 *  
 *  so give line no 58( ie. webservice call)  to executor service
 *
 *  uncomment the parallel execution code and comment the sequential programming and see the difference
 *
 *  Note: Here the service is written in such a way that, it returns response after 5 secs
 *
 *
 *
 */
public class ServiceConsumer {
	//private static final Logger log= Logger.getLogger(ServiceConsumer.class);
	/*public static void main(String[] args) {
		ExecutorService service= Executors.newFixedThreadPool(1);
		
		Client client = Client.create();
		WebResource webResource = client.resource("http://localhost:8080/myservice/stock/price");
		System.out.println(webResource.accept("application/xml").get(String.class));
		System.out.println("after request finish");
			
		//parallel execution
		*//*@SuppressWarnings("unchecked")
		Future future = service.submit(new Callable(){
		    public Object call() throws Exception {
		    	Client client = Client.create();
				WebResource webResource = client.resource("http://localhost:8080/myservice/stock/price");
				System.out.println(webResource.accept("application/xml").get(String.class));
		        return "Callable Result";
		    }
		});*//*
		

	}*/


}
