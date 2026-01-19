package Threads.callback;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Test
 * 
 * Interrupted exception is checked exception,
 * 
 * Because interruption happens by someone not by itself.
 * i.e when some other thread calls interrupt on this thread's object
 * 
 * i.e other thread is an external program to this program. Hence it should be checked exception
 * 
 * Any risk to a program by external program(s) is a checked exception
 * 
 * After interruption a thread can be in terminated state or runnable state
 * 
 * in this below program, thread will be in runnable state after interruption as it needs to execute the line 52
 * if there is nothing to be done, then it will be in terminated state
 *
 *
 */
public class Task implements Runnable{

	String url;
	
	public void run() {
		try {
 				System.out.println("ping status: "+getStatus(getUrl()));
		} catch (IOException e) {
			e.printStackTrace();
		}


	}
	public  String getStatus(String url) throws IOException {

		String result = "";
		try {
			URL siteURL = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) siteURL
					.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int code = connection.getResponseCode();
			if (code == 200) {
				result = "Green";
			}
		} catch (Exception e) {
			result = "->Red<-";
		}
		return result;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
