package Arrays;

/**
 * @author evarapp
 * 
 * take a stack of calls on a paper. We can visualize this is simpler way
 *
 */
public class PrintArrayRecursion {
	public static void main(String[] args) {
		int[] numbers= new int[]{10,13,2,4,15};
		System.out.println("Array ========");
		printArray(numbers, 0);
		System.out.println("Reversed Array ========");
		printArrayReverse(numbers, 0);
		
	}

	
	/**
	 * Prints the array using recursion
	 * @param numbers
	 * @param index
	 */
	private static void printArray(int[] numbers, int index) {
		if(index >0 && index==numbers.length)
			return;
		else{
			System.out.println(numbers[index]);
			printArray(numbers, index+1);
			
		}
		
	}

	/**
	 * 
	 * Prints the array in reverse order using recursion
	 * @param numbers
	 * @param index
	 */
	private static void printArrayReverse(int[] numbers, int index) {
		if(index >0 && index==numbers.length)
			return;
	    else{
	    	printArrayReverse(numbers, index+1);
	    	System.out.println(numbers[index]);
	    	return;
				
			}
		
	}

	
	
}
