package com.idrive;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


/**
 * @author Test
 * 
 * DateFormat is more powerful than SimpleDateFormat and is more useful in the context of i18n
 * 
 * SimpleDateFormat can not parse a String to Date unless it is fed with pattern. Pattern="yyyy-MM-dd" etc
 * The pattern should be in the format our date string is in.
 * 
 * SimpleDateFormat/DateForamt  has a default pattern(dd/MM/yy HH:mm) to format only . This pattern is not applicable for parsing
 * 
 * DateFormat has two beautiful methods.
 * getDateInstance(DateFormat.FULL, new Locale("en").foramt(Date)--->If we want only date portion from the Date object
 * getTimeInstance(DateFormat.FULL, new Locale("en").format(Date)--->if we want only the time portion from the Date Object
 * 
 * 
 *
 */
public class DateUtil {
	static String patterns[]={"MMM-dd-yyyy", "yyyy-MM-dd HH:mm:ss", "dd-MMM-yy HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd", "yyyy/MM/dd"};
	static String date="2013-04-12 10:02:12";
	static int position_dt;
	static String formattedDate;
	static Locale LOCALE=fetchLocale();
	public static void main(String[] args	) throws ParseException {
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		System.out.println("final Date: "+getLocalizedDate(date));
		
	}

	public  static String getLocalizedDate(String date) {
		DateFormat dtf= DateFormat.getDateInstance(DateFormat.FULL,LOCALE);
		try {
			for(int i=position_dt; i< patterns.length; i++ ){
				System.out.println("position is:  "+i);
				position_dt=i;
				formattedDate=dtf.format(new SimpleDateFormat(patterns[i]).parse(date));
				if(formattedDate!=null){
					if(extractTime(date)!=null && extractTime(date)!=""){
						dtf=DateFormat.getTimeInstance(DateFormat.FULL,LOCALE);
						formattedDate=formattedDate+" "+dtf.format(new SimpleDateFormat(patterns[i]).parse(date));
					}
					break;
				}
			}
		} catch (ParseException e) {
			if(position_dt==patterns.length-1)
				e.printStackTrace();
			position_dt=position_dt+1;
			getLocalizedDate(date);

		}

		return formattedDate;
	}


	public static String extractTime(String date){

		return (date.contains(":"))?date.substring(date.indexOf(":")-2).trim():"";
	}


	private static Locale fetchLocale(){
		return new Locale("es");
	}
	

}

