package StringExamples;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Test
 * 
 * http://solvedstack.com/questions/java-array-finding-duplicates
 * 
 *
 */
public class DuplicatesInStringOrArray {
	public static void main(String[] args) {
		System.out.println("Please enter list size");
		Scanner sc= new Scanner(System.in);
		//Accessing a single no from command line
		int length=sc.nextInt();
		int []input= new int[length];
		sc.nextLine();
		System.out.println("Please enter input list");
		
		//Accessing multiple numbers from command line. i.e taking the single input in a loop
		for(int i=0;i<length;i++){
			input[i]=sc.nextInt();
		}
		sc.nextLine();
		System.out.println("Entered list: "+Arrays.toString(input));
		System.out.println(false^true);
		getDuplicateElements(input);
		
		
	}
	static boolean duplicates(final int[] zipcodeList)
	{

		boolean[] mask = new boolean[1002];  // Java guarantees init to false
		for (int item : zipcodeList){
			if (mask[item]) {
				System.out.println(item);
				
			}
		    mask[item]=true;
	}
		return false;
	}
	
	private static boolean getDuplicateElements(int[] input) {
		final int MAXZIP = 9999;
		   boolean[] bitmap = new boolean[MAXZIP+1];  // Java guarantees init to false
		   for (int item : input){
		     if (!(bitmap[item] ^= true)) {
		    	 System.out.println("***duplicates:"+item);
		    	 //return true;
		     }
		   
		   }
		   return false;
	}
	
	
}
