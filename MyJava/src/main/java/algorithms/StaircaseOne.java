package algorithms;

import java.util.Scanner;

/**
 * @author evarapp
 *
 */
public class StaircaseOne {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter input");
		int n=sc.nextInt();
		sc.nextLine();
		printStairCase(n);
	}

	private static void printStairCase(int n) {
		for(int i=0;i<n;i++){
			for(int j=1;j<=n;j++){
				//Different stair cases can be formed just by changing the below condition
				System.out.print(n-i>j?" ":"#");
			}
			System.out.println();
		}
		
	}
}
