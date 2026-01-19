package algorithms;

import java.util.Scanner;

/**
 * @author evarapp
 * 
 * Binary search always divides search space into half
 * 
 * i.e if the size is n, in the first iteration 
 * 
 *  n---n/2
 *  n/2--n/4
 *  .
 *  .
 *  etc
 *  
 *  i.e n-->n/2-->n/4-->n/8-->n/16---n/2^k
 *  
 *  as a whole, search space is divided in n/2^k times in the worst case to find element.
 *  
 *  i.e in the worst case, the search space is divided to 1 element.
 *  
 *  n/2^k=1;
 *  n=2^k
 *  logn= log2^k
 *  taking the base 2==> logn=k
 *  
 *  so to find an element, the seach space should be divided to logn times approxymates
 *  
 *  that means, cpu runs the while loop iteration logn times which is nothing but, dividing the search space by logn times
 *  
 *  so in the worst case binary search takes O(logn) times, where n is the size of the array
 *  
 *  log(5) means==an array of size 5, would be divided by 2+ times to search an element
 *  
 *  so logn ==> how many times, an array of size n is divided to find the given element
 *  
 *  
 *  
 *  
 *  
 *
 */
public class BinarySearch {

	public static void main(String[] args) {

		System.out.println("Please enter size of the array and array elements");
		Scanner sc= new Scanner(System.in);
		int size=sc.nextInt();
		sc.nextLine();
		int[] input= new int[size];
		for(int i=0;i<size;i++){
			input[i]=sc.nextInt();
		}
		sc.nextLine();
		System.out.println("Enter the key to be searched");
		int key=sc.nextInt();
		sc.nextLine();
		sc.close();
		System.out.println("key found at the index:  "+performBinarySearch(input, key));
	}

	private static int performBinarySearch(int[] input, int key) {
		int start=0;
		int end=input.length-1;
		int mid=0;
		int count=0;
		while(start<=end){
			count++;
			mid=(start+end)/2;
			if(key>input[mid]){
				start=mid+1;
			}
			else if(key<input[mid]){
				end=mid-1;
			}
			else{
				System.out.println(mid);
			}

		}
		System.out.println(count+" no of times given array is divided");
		return -1;
	}

}
