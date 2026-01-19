package Threads.Asynchronous;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Test
 *  This is the best example to see the performance using and without using threads.
 *  
 *
 *
 */
public class TestSequentialClient{
	public static void main(String args[]) throws Exception {

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

		for (int i = 0; i < hostList.length; i++) {

			String url = hostList[i];
			String status = getStatus(url);

			System.out.println(url + "\t\tStatus:" + status);
		}
		long end=System.currentTimeMillis();
		
		System.out.println("Time taken:    "+(end-start));

	}

	public static String getStatus(String url) throws IOException {

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

}

