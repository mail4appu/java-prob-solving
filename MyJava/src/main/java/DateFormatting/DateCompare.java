package DateFormatting;

import java.util.Date;

public class DateCompare {
	 public static void main(String args[])
	  {
	    Date firstDate = new Date();
	    System.out.println("firstDate"+firstDate);
	 
	    try
	    {
	      Thread.sleep(1500);
	    }
	    catch(InterruptedException e)
	    {
	      e.printStackTrace();
	    }
	 
	    Date secondDate = new Date();
	    System.out.println("secondDate"+secondDate);
	 
	    int x = firstDate.compareTo(secondDate);
	    System.out.println(x); // prints -1
	  System.out.println("appu".compareTo("bujji"));
	  }

}
