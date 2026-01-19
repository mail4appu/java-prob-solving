package Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadingFrmConsoleExample {
	public static void main(String args[]) throws IOException
	   {
	      String a=null;
	      String str;
	      // Create a BufferedReader using System.in
	      BufferedReader br = new BufferedReader(new 
	                         FileReader("time.txt"));
	      System.out.println("Enter characters, end to quit.");
	      // read characters
	      do {
	         //c = (char) br.read();
	    	  str=(String)br.readLine();
	    	  String s[]=str.split(",");
	         //System.out.println(c);
	    	  for(int i=0;i<s.length;i++){
	    		  System.out.println(s[i]);  
	    	  }
	    	  
	      } while(!str.equals(a));
	   }

}

