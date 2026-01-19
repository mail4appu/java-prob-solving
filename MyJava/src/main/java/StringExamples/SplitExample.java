package StringExamples;

import java.util.Arrays;

public class SplitExample {
	private static String str="insert into config values ('splash_screen_url', '/ipics_server/images/splash.png')";
	public static void main(String[] args) {
		System.out.println("before split:  "+str);
		String[] strArry=str.split("/");
		System.out.println(Arrays.toString(strArry));
		str=str.replace(strArry[3].substring(0, strArry[3].length()-2), "abc.gif");
		System.out.println("str is:  "+str);
		
		
	}

}
