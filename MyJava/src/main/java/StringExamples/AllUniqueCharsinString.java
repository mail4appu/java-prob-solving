package StringExamples;

/**
 * @author Test
 * We have 256 unique ascii chars in english
 * and their values range from 0 to 256. i.e each character's ascii value lies between 0 to 255
 * 
 * ie. if a string has all unique chars its length can  not be more than 256.
 * i.e if String length is > 256 ==> it has duplicate chars
 * 
 *  any character cast to int returns ascii value
 *  
 *  i.e 
 *   here indices from 1 to 255 are ascii values of each unique character available in english.
 *   
 *   Example: "aba"
 *   ascii val of a: 49
 *   so the 49 th index value changed to true now.
 *   when the loop encounters next a, as the 49th index value of the boolean array is true, it returns false
 *   
 *   Time complexity of this algorithm is O(n)
 *    
 *    
 *    This procedure can be used to find whether a String has all unique characters or
 *    find all duplicates in a string
 *  
 *   This works based on the principal false^true=true
 *                                     false^false=false
 *
 *
 */
public class AllUniqueCharsinString {

	public static void main(String[] args) {
		String s="12222abcdac";
		System.out.println(""+uniqueCharsInString(s));
	}
	private static boolean uniqueCharsInString(String s){ 
		boolean bArray[]= new boolean[256];
		System.out.println(false^true);
		System.out.println(true^true);
		if(s.length()>256){
			return false;
		}
		StringBuilder sb= new StringBuilder();
		for(int i=0;i<s.length();i++){
			//returning the ascii value of character
			int val=s.charAt(i);
			System.out.println("Ascci vlaue of "+s.charAt(i)+"  is: "+val);
			if(!bArray[val]){
				bArray[val]^=true;
				//System.out.println("duplicate found:   "+s.charAt(i));
				sb.append(s.charAt(i));
			}
			else{
				System.out.println("duplicate:   "+s.charAt(i));
			}
		}
		int i='2';
		System.out.println("Ascii value of a no: ***** "+i);
		System.out.println(sb);
		return true;

	}


}
