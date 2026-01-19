package algorithms;

/**
 * @author Test
 * 
 * http://opensourceforgeeks.blogspot.in/2013/11/interview-question-15-java-program-to.html
 * 
 * Recursion wih swapping is the trick to achieve the permutations of given string( Not the combinations ) 
 *
 */ 
public class StringPermutations {
	public static void main(String[] args) {
		String str="abc";
		getPerms(str.toCharArray(), 0, str.length()-1);

	}

	private static void getPerms(char[] input, int start, int end){
		if(start==end){
			System.out.println(input);
		}
		else{
			for(int i=start; i<=end; i++){

				char[] temp=getSwappedString(input, start, i);
				getPerms(temp, start+1, end);
			}
		}



	}

	private static char[] getSwappedString(char[] input, int i, int j){
		char temp=input[i];
		input[i]=input[j];
		input[j]=temp;
		return input;
	}


}
