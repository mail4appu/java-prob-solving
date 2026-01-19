package StringExamples;

import java.util.Arrays;

public class StringPerms {
	public static void main(String[] args) {
		String str="abc";
		String original=str;
		int i=0, j;
		while(true){
			if(i<=str.length()){
				j=i+1;
				String returned=swapChars(str.toCharArray(), i, j);
				str=returned;
				i++;
				if(i==str.length()-1){
					j=0;
				}
				if(returned.equals(original))
					break;
			}
		
		}

	}
	
	private static String swapChars(char[] input, int i, int j){
		char temp=input[i];
		input[i]=input[j];
		input[j]=temp;
		
		return Arrays.toString(input);
	}
}
