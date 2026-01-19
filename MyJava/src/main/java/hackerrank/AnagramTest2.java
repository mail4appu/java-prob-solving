package hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramTest2 {
	public static void main(String[] args) {
		System.out.println("Please enter no of test cases ");
		Scanner sc= new Scanner(System.in);
		int length=sc.nextInt();
		sc.nextLine();
		if(length>=1 || length<=10){
			System.out.println("Please enter series");
			for(int i=0;i<length;i++){
				String[] input=sc.nextLine().split("\\s+");
				System.out.println(checkAnagram(input));
			}
		}
		else{
			System.out.println("Not a valid test case no");
		}
	}
	private static String checkAnagram(String[] input){
		if(input.length>500000){
			System.out.println("Please enter valid string");
		}
		else{
			char[] a1=input[0].toCharArray();
			char[] a2=input[1].toCharArray();
			Arrays.sort(a1);
			Arrays.sort(a2);
			if(Arrays.equals(a1, a2)){
				return "YES";
			}
			
		}
		return "NO";
		}

}
