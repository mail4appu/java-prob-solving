package Serialization;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PersistentTime implements Serializable
 {
 private Date time;

 public PersistentTime()
 {
   time = Calendar.getInstance().getTime();
   System.out.println("time initial"+time);
	   }
	 public Date getTime()
	    {
	     return time;
	    }
}
