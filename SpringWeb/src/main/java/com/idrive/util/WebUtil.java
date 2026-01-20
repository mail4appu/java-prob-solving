package com.idrive.util;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {

	public static void printAllReqParams(HttpServletRequest request){
		Map params = request.getParameterMap();
		Iterator i = params.keySet().iterator();
		System.out.println( "======Request params are:========\n");
		while ( i.hasNext() )
		{
			String key = (String) i.next();
			String value = ((String[]) params.get( key ))[ 0 ];
			System.out.println(key+"  : "+value);
		}
	}
	public static int getResult(int n1, int n2){
		
		return n1*n2;
	}

}
