package Arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Test
 *  This class is meant for finding the duplicate elements in array withhout using Collection classes
 *
 */
public class FindDuplicates {
	public static void main(String[] args) {
		System.out.println("Please enter the size of the collection");
		Scanner sc= new Scanner(System.in);
		int size=sc.nextInt();
		sc.nextLine();
		System.out.println("Please fill the collection");
		int input[]= new int[size];
		for(int i=0;i<size;i++){
			input[i]=sc.nextInt();
		}
		sc.nextLine();
		System.out.println("Given input is: "+Arrays.toString(input));
		Arrays.sort(input);
		findDuplicates(input);
	}
	private static void findDuplicates(int[] input){
		
		
		for(int i=0;i<input.length-1;i++){
			if(input[i]==input[i+1]){
				System.out.println("Duplicate found: "+input[i]);
				//skip printing of  further duplicate elements, by incrementing the i variable n doing nothing else
				
				while(true){
					if(input[i+1]==input[i+2] && (i+1)<input.length-1 ){
					   i++; //increment i value n do nothing else
					}else{
						break;
					}
				}
			}
		}
		
	}
}
