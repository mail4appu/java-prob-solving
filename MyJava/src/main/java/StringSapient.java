
public class StringSapient {
	String name;
	void display(StringSapient s){
		s.name="Akash";
		s=null;
		
	}
	
 public static void main(String[] args) {
	 StringSapient s= new StringSapient();
	 s.name="Ashwini";
	 String s2= new String("Ashwini").intern();
	 System.out.println(s.name==s2);
	 String str = "helloslkhellodjladfjhello";
	 String findStr = "hello";
	 System.out.println(str.indexOf(findStr, findStr.length()));
	 System.out.println(str.split(findStr, -1).length-1);
	 s.display(s);;
	 System.out.println(s.name);
 }
}
	
	 
