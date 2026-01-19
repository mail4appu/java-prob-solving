import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class FormFeeding {
	public static void main(String[] args)
	  {
	    try
	    {
	      URL url = new URL( "http://kspace.in/blog/2008/05/30/submit-html-form-using-java/" );
	 
	      HttpURLConnection hConnection = (HttpURLConnection)
	                             url.openConnection();
	      
	      HttpURLConnection.setFollowRedirects( true );
	 
	      hConnection.setDoOutput( true );
	      hConnection.setRequestMethod("POST");	
	 
	      PrintStream ps = new PrintStream( hConnection.getOutputStream() );
	      ps.print("param1=abcd&amp;param2=10341");
	      ps.close();
	 
	      hConnection.connect();
	 
	      if( HttpURLConnection.HTTP_OK == hConnection.getResponseCode() )
	      {
	        InputStream is = hConnection.getInputStream();
	        OutputStream os = new FileOutputStream("C:/Documents and Settings/vapparao/workspace/MyProject/src/ouput.html");
	        int data;
	        while((data=is.read()) != -1)
	        {
	          os.write(data);
	        }
	        is.close();
	        os.close();
	        hConnection.disconnect();
	      }
	    }
	    catch(Exception ex)
	    {
	      ex.printStackTrace();
	    }
	  }

}
