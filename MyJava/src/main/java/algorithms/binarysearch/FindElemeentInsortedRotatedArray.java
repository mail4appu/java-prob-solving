package algorithms.binarysearch;

import java.util.Scanner;

/**
 * @author evarapp
 * 
 * ex: 22  33  45  56  66  12  15  21
 *
 */
public class FindElemeentInsortedRotatedArray {
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
		System.out.println("Please enter the element to search for");
		int key=sc.nextInt();sc.nextLine();
		System.out.println("found at index:  "+findKey(input,key ));
	}

	private static int findKey(int[] arr, int key) {
		int start=0;
		int end=arr.length-1;
		while(start<=end){
			int mid=(start+end)/2;

			if(key==arr[mid])
				return mid;
			else if(arr[start]<=arr[mid]){ //left is sorted
				//if the key lies be				// tween start and mid i.e sorted part, then search only left part
				if(key>=arr[start] && key<=arr[mid]){
					end=mid-1; //discarding right part and searching left part( i.e sorted part)
				}
				else{
					start=mid+1; //discardign left part, search in unsorted part
				}

			}
			else{ //right is sorted
				//if the key lies between mid and high, then search only right part
				if(key>=arr[mid] && key<=arr[end]){
					start=mid+1;
				}
				else{
					end=mid-1;
				}
			}

		}
		return -1;


	}

}
