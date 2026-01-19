package StringExamples;

import java.util.Scanner;

/**
 * @author vapparao
 *
 *if a given number is not divisible by any of the numbers that are less than the half of the given number
 *except 1, is a prime number
 *
 *Here we are getting no of prime numbers that are less than a given number
 *
 *
 */
public class PrimeNumberCheck {
	
	public static void main(String[] args) {
		System.out.println("Please enter a number");
		Scanner sc= new Scanner(System.in);
		int no=sc.nextInt();
		int count=0;
		//Getting the no of prime numbers below the entered no
		for(int i=2;i<=no;i++){
			if(isPrimeNumber(i)){
				System.out.print(i+" ");
				count++;
			}
		}
		System.out.println("No of primes that are less than: "+no+"   : are:  "+count);
		
	}
	private static boolean isPrimeNumber(int n){
		for(int j=2;j<=n/2;j++){
			if(n%j==0){
				return false;
			}
			
		}
		return true;
	}
}
