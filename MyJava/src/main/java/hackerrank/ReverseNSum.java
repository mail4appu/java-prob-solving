package hackerrank;
import java.util.Scanner;




public class ReverseNSum {

	public static void main(String[] args) {
		System.out.println("Please enter no of test cases ");
		Scanner sc= new Scanner(System.in);
		int length=sc.nextInt();
		sc.nextLine();
		System.out.println("Please enter series");
		for(int i=0;i<length;i++){
			String[] input=sc.nextLine().split("\\s+");
			System.out.println("Result for the line: "+reverseNSum(input));
		}


	}
	private static int reverseNSum(String[] input){
			return getReversedNumber((getReversedNumber(Integer.parseInt(input[0].trim()))+getReversedNumber(Integer.parseInt(input[1].trim()))));
		
		
	}
	
	private static int getReversedNumber(int n){
		int rev=0;
		while(n!=0){
			rev=rev*10;
			rev=rev+n%10;
			 n=n/10;
		}
		return rev;
	}

}


