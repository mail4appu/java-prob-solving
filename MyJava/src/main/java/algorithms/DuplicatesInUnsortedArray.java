package algorithms;

/**
 * @author evarapp
 * 
 * This technique works for the array of n elements where elements range from 
 * 1 to n-1********
 *
 */
public class DuplicatesInUnsortedArray {
	
	public static void main(String[] args) {
		int[] input= {1,4,4,4,4,4,6};
		for(int i=0;i<7;i++){
			if(input[Math.abs(input[i])]>0){
				input[Math.abs(input[i])]=-input[Math.abs(input[i])];
			}
			else{
				System.out.println("duplicate is:   "+Math.abs(input[i]));
			}
			
		}
		
		
	}

}
