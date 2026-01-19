import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;



public class Example {
	public static void main(String args[])throws Exception{
	URL url = new URL( "https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=http://mail.google.com/mail/&scc=1&ltmpl=default&ltmplcache=2?Email=mail4appu@gmail.com&Passwd=abc" );
	
	InputStreamReader isr= new InputStreamReader(url.openStream());
	{
	BufferedReader br=new BufferedReader(isr);
	
	String line="";
    while((line=br.readLine())!=null){
    	System.out.println(line);
    }
	}
	}
}
