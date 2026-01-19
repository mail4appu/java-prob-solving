package algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaFactorialUsingRecursion {
	public static void main(String args[]) throws NumberFormatException, IOException{
        
        System.out.println("Enter the number: ");
       
        //get input from the user
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
       
        //call the recursive function to generate factorial
        int result= fact(n);
        
       
       
        System.out.println("Factorial of the number is: " + result);
}

static int fact(int n)
{
        if(n <= 1)
                //if the number is 1 then return 1
                return 1;
        else
                //else call the same function with the value - 1
                return n * fact(n-1);
}
}
