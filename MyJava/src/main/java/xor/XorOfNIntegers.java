package xor;

import java.util.Scanner;

/**
 * @author evarapp
 * 
 *   #first three
 *   1^2^3=0
 *   #First five
 *   (1^2^3)^4^5=1
 *   (1^2^3^4^5^)^6=7
 *   (1^2^3^4^5^6^7)=0
 *   (1^2^3^4^5^6^7)^8=8
 *   (1^2^3^4^5^6^7^8)^9=1
 *   #First 10 digits
 *   (1^2^3^4^5^6^7^8^9)^10=11
 *   
 *   
 *   1^2=3
 *   1^4=5
 *   1^6=7
 *   1^8=9
 *   1^10=11
 *   
 *   1 xor any even integer  i.e multiple of 2  always produces next integer
 *   
 *   2 powers ^ with  next no produces always 1
 *   
 *   2^3=1
 *   4^5=1
 *   8^9=1
 *   16^17=1
 *   32^33=1
 *   
 *   
 *   Very important:
 *   a^b^c=a^c^b
 *   
 *   its like a+b+c=a+c+b
 *
 */
public class XorOfNIntegers {
	public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    System.out.println("Please enter the size of input");
    int input= sc.nextInt();
    sc.nextLine();
    int xorResult=0;
    for(int i=1;i<=input;i++){
    	xorResult=xorResult^i;
    }
    System.out.println("xor result:   "+xorResult);
	}
}
