package StringExamples;

import java.util.Scanner;

/**
 * @author evarapp
 *  Lets take the String as fun
 *  
 *  The possible substrings will be "f", "fu", "fun", "u", "un", "n"
 *  
 */
public class FindAllSubstrings {
	public static void main(String[] args) {
     Scanner sc= new Scanner(System.in);
     System.out.println("Please enter the input string");
     String input=sc.nextLine();
     printAllSubStrings(input);
	}

	private static void printAllSubStrings(String input) {
		
		for(int i=0;i<input.length();i++){
			for(int j=i+1; j<=input.length();j++){
				//i==starting index, j==ending index
				//the length of the string it returns is j-i** this is the trick here
				String subStr=input.substring(i,j);
				System.out.println(subStr);
			}
		}
		
	}
}
