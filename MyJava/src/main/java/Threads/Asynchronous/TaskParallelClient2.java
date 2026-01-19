package Threads.Asynchronous;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TaskParallelClient2 {

    private static final int MYTHREADS = 10;
    private static CountDownLatch countDownLatch;

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
        countDownLatch=new CountDownLatch(hostList.length);
        long start=System.currentTimeMillis();
        List<Future> results=new ArrayList<Future>();
        for (int i = 0; i < hostList.length; i++) {

            String url = hostList[i];
            //Here we are creating multiple jobs and giving it to the thread pool
            Runnable job = new Myrunnable(url);
            results.add(service.submit(job));
        }
        //This will wait till countdown becomes zero. If main thread requires to wait max 10 secs,
       // countDownLatch.await();
        countDownLatch.await(10, TimeUnit.SECONDS); // Here if countdown does not become zero, max 10 secs it waits
        long end=System.currentTimeMillis();
        System.out.println("Time taken:    "+(end-start));
        System.out.println("\nFinished all threads");


    }
}
