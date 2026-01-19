package Threads.Asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Test
 * 
 * Multithreading is java way of achieving multi tasking
 * 
 * Program under execution is process
 * A thread is incharge of some of the statements of the program
 * 
 * MultiThreading is aimed at achieving multitasking or parallel processing and to reduce the
 * processor idle time
 * 
 * If we consider a program as process, Then thread can be called as subprocess
 * as it executes a block or some statements of that program
 * 
 * Read more @: http://way2java.com/multithreading/java-thread-basics/
 * 
 * 
 *
 * Herer 54 sites are given to 30 threads being executed in parallel
 * 
 * i.e 54 jobs are given to 30 workers
 *
 * The code between the lines 71 and 77 is very important
 * 
 * 
 *
 *
 *
 */
public class TaskParallelClient{
	private static final int MYTHREADS = 10;
	 
    public static void main(String args[]) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(MYTHREADS);
        String[] hostList = { "http://crunchify.com", "http://yahoo.com",
				"http://www.ebay.com", "http://google.com",
				"http://www.example.co", "https://paypal.com",
				"http://bing.com/", "http://techcrunch.com/",
				"http://mashable.com/", "http://thenextweb.com/",
				"http://wordpress.com/", "http://wordpress.org/",
				"http://example.com/", "http://sjsu.edu/",
				"http://ebay.co.uk/", "http://google.co.uk/",
				"http://www.wikipedia.org/",
				"http://en.wikipedia.org/wiki/Main_Page",
				"http://crunchify.com", "http://yahoo.com",
				"http://www.ebay.com", "http://google.com",
				"http://www.example.co", "https://paypal.com",
				"http://bing.com/", "http://techcrunch.com/",
				"http://mashable.com/", "http://thenextweb.com/",
				"http://wordpress.com/", "http://wordpress.org/",
				"http://example.com/", "http://sjsu.edu/",
				"http://ebay.co.uk/", "http://google.co.uk/"
				
		};
        long start=System.currentTimeMillis();
        List<Future> results=new ArrayList<Future>();
        for (int i = 0; i < hostList.length; i++) {
 
            String url = hostList[i];
            //Here we are creating multiple jobs and giving it to the thread pool
            Runnable job = new Myrunnable(url);
            results.add(service.submit(job));
        }
        //executor is closed for accepting new tasks. i.e it will not accept any new threads
        service.shutdown();
       
        // Wait until all threads are finished. This is very  important block of code
        while (!service.isTerminated()) {
        }
        //This is second way in which the main thread waits, till the children are done. Here we can use either the while block or below for loop
        //to wait for children to be done. Both are not required. actually one is enough. Just to see the result i have written both here
        /*for(Future f:results){
        	System.out.println(f.get());
        }*/
        long end=System.currentTimeMillis();
        System.out.println("Time taken:    "+(end-start));
        System.out.println("\nFinished all threads");
	
}
}
