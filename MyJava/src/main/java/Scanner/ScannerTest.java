package Scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter your input");

		try{
			int p=sc.nextInt();
			int q=sc.nextInt();
			sc.nextLine();
			System.out.println(p + ":  "+q );
		}catch(InputMismatchException ex){
			System.out.println("exception");
		}


	}
}
