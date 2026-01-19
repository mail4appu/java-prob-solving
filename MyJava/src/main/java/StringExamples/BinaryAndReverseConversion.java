package StringExamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BinaryAndReverseConversion {
	public static void main(String[] args) {
		
		System.out.println("Please enter a value");
		Scanner sc= new Scanner(System.in);
		int input=sc.nextInt();
		sc.nextLine();
		System.out.println("Value is: "+input+"  : its binary value: "+Integer.toBinaryString(input));
		System.out.println("Value is: "+input+"  : its hex value: "+Float.toHexString(input));
		getBinaryValue(input);
		
		
		
		
	}

	private static void getBinaryValue(int input) {
		// TODO Auto-generated method stub
		List<Integer> binaryList= new ArrayList<Integer>();
		
		while(input>0){
			int rem=input%2;
			binaryList.add(rem);
			input=input/2;
		}
		Collections.reverse(binaryList);
		System.out.println("Binary value is"+binaryList);
	}

}
