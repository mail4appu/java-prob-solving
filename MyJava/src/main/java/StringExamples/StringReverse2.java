package StringExamples;

import java.util.Arrays;

/**
 * @author vapparao
 * 
 * temp=a[i];
 * a[i]=a[j];
 * a[j]=temp;
 * 
 * this is the swapping program of two numbers.
 * this applies everywhere in case of reversing
 * 
 * In Array Reversing or String reversing 
 * the trick is (size-1)-i
 *
 */
public class StringReverse2 {
	
	public static void main(String[] args) {
		String mystr="abcdefghijklmnopqrstuvwxyz";
		char ch[]=mystr.toCharArray();
		for(int i=0;i<ch.length/2;i++){
			char temp=ch[i];
			ch[i]=ch[(ch.length-1)-i];
			ch[(ch.length-1)-i]=temp;
		}
		System.out.println(" reversed string is"+Arrays.toString(ch));
	}

}
