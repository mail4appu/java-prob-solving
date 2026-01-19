package algorithms;

import java.util.Scanner;

public class StringLength {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Please enter a String");
		String s= sc.nextLine();
		System.out.println("length of the given string is: "+getLength(s));
	}

	private static int getLength(String s) {
		// TODO Auto-generated method stub
		int i=0;
		try{
			while(true){
				s.charAt(i);
				i++;
			}
		}catch(IndexOutOfBoundsException ex){
			return i;
		}


	}

}
