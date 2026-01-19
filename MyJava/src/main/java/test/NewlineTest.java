package test;

public class NewlineTest {
	
public static void main(String[] args) {
	String s="WARNING!!!\n                    READ THIS BEFORE ATTEMPTING TO LOGON\n\n      This System is for the use of authorized users only.  Individuals\n      using this computer without authority,";
			s=s.replaceAll("\\n", "<br>");
			System.out.println("s is:   "+s);
			String a=s;
			System.out.println("a is"+a);
			
   String str="monit: No daemon process found";
   System.out.println("index is");
   String liner=str.substring(str.indexOf("monit:"));
   System.out.println("liner is: "+liner);
}
}
