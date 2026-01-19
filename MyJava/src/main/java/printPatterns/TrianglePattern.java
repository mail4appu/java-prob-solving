package printPatterns;

import java.util.Scanner;

public class TrianglePattern {
	public static void main(String[] args) {
		try{
			System.out.println("Please enter  a number");
			Scanner  sc= new Scanner(System.in);
			int n=sc.nextInt();
			System.out.println(n);
			for(int i=1;n>0 && i<n;i++){
				for(int j=1;j<=i;j++){
					System.out.print(i+"  "); //replace i with j and see the result
					
				}
				System.out.println("\n");
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}


	}
}

