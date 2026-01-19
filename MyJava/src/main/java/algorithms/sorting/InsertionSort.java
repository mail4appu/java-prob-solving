package algorithms.sorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Test
 * 
 * This insertion sort is used when arranging books in shelf when each book numbered
 * Arranging clothes in tailor shop.
 * 
 * Very simple technique: we start with first element and compare with its previous element.
 * 
 * When previous element is less than first element, then we swap. This should happen in the back ward direction till it reaches the first element
 * We keep moving in the forward direction with variable i;
 * after swap, we compare two elements in the reverse direction. 
 * 
 * j is meant for reverse direction traversal and swapping the elements.
 * i is meant for hold the index where we started coming in the reverse direction
 * 
 * 
 * 
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		System.out.println("Please enter size of the series");
		Scanner sc= new Scanner(System.in);
		int size=sc.nextInt();
		int[] input= new int[size];
		sc.nextLine();
		System.out.println("Please enter the series");
		for(int i=0;i<size;i++){
			input[i]=sc.nextInt();
		}
		sc.nextLine();
		System.out.println("Series after sorting:"+Arrays.toString(getSortedInput(input)));
		
		
	}
	private static int[] getSortedInput(int[] input){
		for(int i=0;i<input.length;i++){
			int j=i;
			while(j>0){
				if(input[j]<input[j-1]){ //Simple swapping technique
					int temp=input[j];
					input[j]=input[j-1];
					input[j-1]=temp;
				}
				j--;
			}
		}
		return input;
	}
}
