package StringExamples;

/**
 * @author apparao
 * 
 * 
 * Left shift===> multiplication with 2 power n
 * Right shift==> devision with 2 power of n
 * 
 * Example: 10<<3==>10*(2 power 3)==80
 *           
 * 
 * Calculating binary value of negative no:
 * 1. take the twos compliment. i.e the binary value of the no
 * 2. negate the binaray value. i.e replace 0s with 1s and 1s with 0s
 * 3. Add 1 to the negated value
 * 
 * Example: Binary value of -6
 * 1. binary value of 00000110 (8 bit)
 * 2. Negatet the binary value, 11111001
 * 3. Add 1 to the negated value,  11111001
 *                                        1
 *                                 ---------
 *  Binary value of -6 is:         11111010
 *                                 
 * 
 * 
 * Integer is 4 bytes in java
 * hence when we print, binary value of a no we get 32 bit string
 * 
 * 
 *
 */
public class LogicalOperations {
	public static void main(String[] args) {
		System.out.println("Left shift opertion: 11<<3  ="+(11<<3));
		System.out.println("Right shift opertion: 11>>3  ="+(11>>3)); 
		System.out.println("Xor operation: 11^9    ="+(11^9));
		System.out.println("Xor operation: 2^9    ="+(2^9));
		System.out.println("Xor operation: 11^2    ="+(11^2));
		
		
		System.out.println("Binary Value of positive no 6 is :  "+Integer.toBinaryString(6));
		System.out.println("Binary vlaue of negative no -6 is:  "+Integer.toBinaryString(-6));// Ans: 11111111111111111111111111111010
		
		//Converting Binary String to its equivalent integer
		System.out.println("Integer value from binary String 10101:   "+Integer.parseInt("10101", 2));
		
	}

}
