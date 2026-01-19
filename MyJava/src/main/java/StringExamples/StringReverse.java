package StringExamples;

/**
 * @author vapparao
 * Reversing the string without using StrinBuffer/Builder
 */
public class StringReverse {
	public static void main(String args[]){
		String s="abcdefghijklmnopqrstuvwxyz";
		StringReverse rev= new StringReverse();
		String reversedString=rev.reverse(s);
		System.out.println("the reversed string is::    "+reversedString +"   ::and its length is:  "+reversedString.length());

}
	public String reverse(String s) {
	    String revString="";
		for(int i=s.length();i>=1;i--){
			revString=revString+s.charAt(i-1);
		}
		return revString;
	}
}
