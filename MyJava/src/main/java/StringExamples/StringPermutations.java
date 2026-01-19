package StringExamples;

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
		String str="123";
		getPerms(str.toCharArray(), 0, str.length()-1);

	}

	private static void getPerms(char[] input, int start, int end){
		if(start==end){
			System.out.println(input);
		}
		else{
			for(int i=start; i<=end; i++){
				if(i!=start)
			    //swap 1 with 1 i.e fixing 1  and in the next statement, we are getting the permutations with 2 & 3 
				swapChars(input, start, i);
				getPerms(input, start+1, end);
				if(i!=start)
				swapChars(input, start, i);
			}
		}



	}

	private static void swapChars(char[] input, int i, int j){
		char temp=input[i];
		input[i]=input[j];
		input[j]=temp;
		//System.out.println(Arrays.toString(input)+ "*****");
		return ;
	}


}
