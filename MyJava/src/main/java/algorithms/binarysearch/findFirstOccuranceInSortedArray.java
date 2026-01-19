package algorithms.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author evarapp
 * 
 * In a duplicate sorted array, binary search returns the random index.
 * if we want the first occurrence, we should go left from the random index.
 * so result=end-1;
 * and if we want the last occurrence, we should go right from the random index
 * hence result=mid+1
 * 
 * this is the only statement that changes from the normal binary search logic
 * 
 * 
 *
 */
public class findFirstOccuranceInSortedArray {
	public static void main(String[] args) {
		System.out.println("Please enter size of an array");
		Scanner sc= new Scanner(System.in);
		int size=sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter array elements");
		int []input=new int[size];
		for(int i=0;i<size;i++){
			input[i]=sc.nextInt();
		}
		sc.nextLine();
		Arrays.sort(input);
		System.out.println("Enter the key to search");
        int key=sc.nextInt();
        sc.nextLine();
        findFirstOccurance(input, key);
	}

	private static void findFirstOccurance(int[] arr, int key) {
		
		int start=0;
		int end=arr.length-1;
		int result=-1;
		while(start<=end){
			int mid=(start+end)/2;
			if(key==arr[mid]){
				result=mid;
				end=mid-1; // as first occurrence lies towards the left of the random index
				//start=mid+1 // as the last occurrence lies towards the right of the random index
			}
			else if(key<arr[mid]){
				end=mid-1;
			}
			else{
				start=mid+1;
			}
			
		}
		System.out.println("First occurance of "+key+" is at  index : "+result);	
	}
	

}
