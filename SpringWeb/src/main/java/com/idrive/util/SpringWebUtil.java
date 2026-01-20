package com.idrive.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * @author Test
 * Look in the below website for example dates and their patterns
 * 
 * http://www.studytrails.com/java/date/java-DateFormat-SimpleDateFormat.jsp
 *
 */
@Component
public class SpringWebUtil {
	
	ReloadableResourceBundleMessageSource messageSource;
	SessionLocaleResolver localeResolver;
	
	static String patterns[]={"MMM-dd-yyyy",  "dd-MMM-yy HH:mm:ssZ", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd HH:mm:ss"};
	static int position;
	static String formattedDate;
	
	
	public void sayHi() throws ParseException{
		//Locale locale = RequestContextUtils.getLocale(request);
		messageSource=(ReloadableResourceBundleMessageSource)SpringContextUtil.getApplicationContext().getBean("messageSource");
		//localeResolver=(SessionLocaleResolver)SpringContextUtil.getApplicationContext().getBean("localeResolver");
		//System.out.println("util:  locale resolver object is "+localeResolver);
		String args[]= new String[5];
		args[1]="appu";
		String localizedMsg=messageSource.getMessage("contrl.msg", args,  LocaleContextHolder.getLocale());
		System.out.println("inside util:  "+localizedMsg);
		
		
	}
	
	
	public  static String getLocalizedDate(String date) {
		DateFormat dtf= DateFormat.getDateInstance(DateFormat.LONG, LocaleContextHolder.getLocale());
		try {
			for(int i=position; i< patterns.length; i++ ){
				System.out.println("position is:  "+i);
				position=i;
				formattedDate=dtf.format(new SimpleDateFormat(patterns[i]).parse(date));
				if(formattedDate!=null){
					break;
				}
			}
		} catch (ParseException e) {
			if(position==patterns.length-1)
				e.printStackTrace();
			position=position+1;
			getLocalizedDate(date);
			
		}

		return formattedDate;
}
	
	
	@SuppressWarnings("unchecked")
	public static  JSONObject getJson(){
		JSONObject json= new JSONObject();
		try {
			BufferedReader br= new BufferedReader(new InputStreamReader( new FileInputStream(new File("/home/Test/workspace/MyJava/src/messages_en.properties"))));
			String line="";
			
			
			while((line=br.readLine())!=null){
				if(!line.equals("") && line.contains("=")){
					String keyValues[]=line.split("=");
                    json.put(keyValues[0], keyValues[1]);

				}

			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
}
