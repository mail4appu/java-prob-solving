package com.idrive;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class DateTimeUtil {
	public static void main(String[] args) {
		try {
			DateFormat dtf= DateFormat.getTimeInstance(DateFormat.FULL, new Locale("es"));
			System.out.println(dtf.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2013-04-12 10:02:12")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
