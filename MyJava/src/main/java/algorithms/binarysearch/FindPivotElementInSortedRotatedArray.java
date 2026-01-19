package algorithms.binarysearch;

import java.util.Scanner;

/**
 * @author evarapp
 * 
 *   ex1= 3  4 5  1  2
 *   ex2= 22  33  45  56  66  12  15  21
 * 
 * Pivot element is the minimum element in the sorted rotated array
 * 
 * if(previous>next), then next is pivot element. this takes O(n) times
 * 
 * so using binary search, compare mid and mid+1
 * 
 * if a[mid]>a[mid+1], then mid+1 is pivot
 * 
 * in sorted rotated array, either start to mid or mid to end will be sorted but not both the parts
 * 
 * Pivot always exists in the unsorted part.
 * so we need to identify sorted part of the array in each division and discard it
 * 
 * Binary search talks about dividing the space into two halves and discarding the one sorted part
 * 
 * 
 * 
 * 
 *
 */
public class FindPivotElementInSortedRotatedArray {
	public static void main(String[] args) {
		System.out.println("Please enter size of an array");
		Scanner sc= new Scanner(System.in);
		int size=sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter sorted rotated Array");
		int []input=new int[size];
		for(int i=0;i<size;i++){
			input[i]=sc.nextInt();
		}
		sc.nextLine();
		findPivotElement(input);
		
	}

	private static void findPivotElement(int[] input) {
		
		int start=0;
		int end=input.length-1;
		while(start<=end){
			int mid=(start+end)/2;
			
			if(input[mid]>input[mid+1]){
				System.out.println("pivot index is:  "+(mid+1));
				return;
			}
			else if(input[start]<=input[mid]){ //left is sorted array. so discard this sorted array as pivot can not exist in sorted part
				start=mid+1;
			}
			else{ //right is sorted so discard this right part as pivot can not exist in sorted part
				end=mid-1;
			}
			
			
		}
		
		return;
	}

}
