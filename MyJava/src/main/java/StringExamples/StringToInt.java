package StringExamples;


/**
 * @author Test
 * 
 * Trick is: getting the ascii value of a character.
 * When you cast any character to int, we will get its ascii value
 * 
 * Ascii value of '0' is 48 and '9' is 57
 * 
 * Any characters ascii value between 48 to 57 is considered as integer
 * 
 * 
 * converting int character to int 
 * 
 * if int char is 9
 * int i='9'-'0'. It should be casted to int
 *
 */
public class StringToInt {

	public static void main(String[] args) {
		String str="123";
		int r=0;
		for(int i=0;i<str.length();i++){
			r*=10;
			//here as the r is int, the whole operation is being casted to int
			int temp=str.charAt(i)-'0';
			r=r+temp;
		}
		int i='9'-'0';
		System.out.println(i);
		System.out.println(r);
		convertIntToString(123);
		
			
	}
	public static void convertIntToString(int no){
		
		StringBuffer sb= new StringBuffer();
		while(no>0){
			int rem=no%10;
			//here the trick is, insert always at 0 index, so that the element already at index 0 is moved by one place to right 
			//This is like, adding a element in arrayList at some index. adding a element at index, inserts the element in ArrayList
			sb.insert(0, rem);
			no=no/10;
			
		}
		System.out.println(sb);
		
	}
}
