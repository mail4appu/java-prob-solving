package com.idrive.test;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] numbers={3,8,9,4,2,1};
		for(int i=1;i<numbers.length; i++){
			int j=i;
			while(j>0){
				if(numbers[j-1]>numbers[j]){
					int temp=numbers[j];
					numbers[j]=numbers[j-1];
					numbers[j-1]=temp;
					
				}
				j=j-1;
			}
			
		}
		System.out.println(Arrays.toString(numbers));
	}
	
}
