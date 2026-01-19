package problems;

import java.util.Arrays;
import java.util.Scanner;


public class FindMissingNumbers {
	public static void main(String[] args) {
    
		java.util.Scanner scanner= new Scanner(System.in);
		System.out.println("Please enter the max limit");
		//nextInt like methods identify the input wiht space or enter***
		int limit=scanner.nextInt();
		scanner.nextLine();
		System.out.println("Please enter the sequence size");
		int size= scanner.nextInt();
		scanner.nextLine();
		System.out.println("Please enter the sequence");
		int input[] = new int[size];
		for(int i=0;i<size;i++){
			input[i]=scanner.nextInt();
			
		}
		scanner.nextLine();	
		System.out.println("Entered sequence is"+Arrays.toString(input));
				
		getMissingNumbers(input);
		
	}
	
	private static void getMissingNumbers(int[] input){
		int j=input[0];
		for(int i:input){
			if(i!=j){
				System.out.println("Missing no is: "+j);
				j=i;
			}
			j++;
		}
		
	}
}
