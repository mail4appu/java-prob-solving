package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Test
 * Scanner is meant for accessing all the data types either in bulk or single entity
 * ****We should never accepts integers or floats as strings and convert them back to respective types. Its a performance head.
 * 
 * nextInt(), nextFloat() etc always consider just the int/float values entered not the new line i.e enter button pressed
 * 
 * so to make it accept the enter button as well we should give sc.nextLine() right after accepting the int/float value.
 * 
 * but sc.nextLine() accepts the string along with the new line entered i.e enter button
 * 
 * The beauty while accessing the entities in loop is, even if we give more no of entities than the loop length, it does not throw any exception and accepts only the required no of elements or entities
 * 
 * When you input less no of entities than the loop length, scanner will not proceed un-till the required no of inputs are given 
 *
 *
 */
public class ScannerAccessingInputs {
	public static void main(String[] args) {
		System.out.println("Please enter the series length");
		Scanner sc= new Scanner(System.in);
		int length=sc.nextInt();
		//Accepting the enter pressed
		sc.nextLine();
		int []series=new int[length];
		System.out.println("Please enter the series");
		//Accessing the series of ints or bulk of ints 
		for(int i=0;i<length;i++){
			series[i]=sc.nextInt();
		}
		sc.nextLine();
		System.out.println("Entered series: "+Arrays.toString(series));
	}

}
