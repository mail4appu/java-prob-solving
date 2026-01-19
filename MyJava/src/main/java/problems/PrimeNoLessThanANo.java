package problems;

import java.util.Scanner;

public class PrimeNoLessThanANo {
	public static void main(String[] args) {
		System.out.println("Please enter a no");
		Scanner sc= new Scanner(System.in);
		int input=sc.nextInt();
		int count=0;
		for(int i=2; i<=input;i++){
			if(isPrimeNo(i)){
				count++;
			}
		}
		System.out.println(count);
		
	}

	public static boolean isPrimeNo(int n){
		for(int j=2; j<=n/2;j++){
			if(n%j==0){
				return false;
			}
			
		}
		return true;
	}
}
