package StringExamples;


public class SubstringTest {
	
	public static void main(String[] args) {
		String line="2014-06-26 15:00:10 ERROR        :  HA CONFIG ABORTED WITH 1 ERROR(S)";
		String error=line.substring(line.indexOf("ERROR")+"ERROR".length());
		if(error.contains(":")){
			error=error.replace(":", " ");
		}
		
		 System.out.println(error);
		  
		    String testStr = "/a'b'c//''&";
		 
			System.out.println("Original : " + testStr);
	 
			System.out.println("Escaped : " + testStr.replaceAll("['/&]", ""));
	 
	}
	
	
	
}
