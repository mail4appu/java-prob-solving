package StringExamples;

import java.util.Scanner;

/**
 * @author evarapp
 * 
 * 
 * Printing all substrings without using substring method
 * 
 * Here we are using recursion.
 * 
 * Example:
 * "fun" is the given input. the possible substrings are
 * starting with first char: "f", "fu", "fun"
 * starting with sec char: "u", "un"
 * starting with third char:n
 * 
 * Tric: First take the whole string and starting with first print all sub strings
 * starting with next, we can use recursion with replace technique
 * 
 * 
 * No of substrings if length of string is n
 * n(n+1)/2
 *
 */
public class AllSubStringsRecursion {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter the input string");
		String input=sc.nextLine();
		printSubString(input);

	}

	private static void printSubString(String input) {
		if(input.length()==0){
			return;
		}
		
		String result="";
       for(int i=0;i<input.length();i++){
    	   result=result+input.charAt(i);
    	   System.out.println(result);
       }
       //recursion with rest of the string
       if(result.length()==input.length()){
    	   
    	   printSubString(result.replace(""+result.charAt(0), ""));
       }
	}
	
}