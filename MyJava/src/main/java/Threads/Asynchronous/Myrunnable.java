package Threads.Asynchronous;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.CountDownLatch;

/**
 * @author Test
 *
 * Anything that implements Runnable is like the job/task (object) to be done by the threads
 *
 */
public class Myrunnable implements Runnable{
	private final String url;
	CountDownLatch countDownLatch;
	 
    Myrunnable(String url) {
        this.url = url;
    }

    public Myrunnable(String url, CountDownLatch countDownLatch) {
        this.url = url;
        this.countDownLatch = countDownLatch;
    }

    //The run method is the job of a thread
    public void run() {

        String result = "";
        int code = 200;
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            code = connection.getResponseCode();
            if (code == 200 ) {
                result = "Green\t";
                if(countDownLatch!=null){
                    countDownLatch.countDown();
                }
            }
        } catch (Exception e) {
            result = "->Red<-\t";
        }
        System.out.println(url + "\t\tStatus:" + result);
    }
}
