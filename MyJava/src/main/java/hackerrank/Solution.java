package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Please enter value ");
		Scanner sc= new Scanner(System.in);
		int length=sc.nextInt();
		sc.nextLine();
		int []input= new int[length];
		System.out.println("Please enter series");
		
		for(int i=0;i<length;i++){
			input[i]=sc.nextInt();
		}
		sc.nextLine();
		System.out.println(Arrays.toString(input));
	}

}
