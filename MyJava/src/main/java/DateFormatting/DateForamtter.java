package DateFormatting;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateForamtter {
	public static void main(String args[]) throws Exception
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		  Date dt= new Date();
	      System.out.println("curent date is: ** "+sdf.format(System.currentTimeMillis()));


	}

}
