package Arrays;

import java.util.Arrays;

/**
 * @author vapparao
 * 
 * We can compare arrays using Arrays.equals(a1, a2)
 * 
 * We can sort any array using Arrays.sort(arrayName)--this uses quick sort algorithm
 * Where as Collections.sort(list)----This uses merge sort algorithm 
 * 
 * Collections.sort(list);             |
 * Collectioins.reverse(list)          |these two modify the underlying data structure
 * Collections.binarySearch(list)
 * |
 * |These three methods only accept lists
 * 
 *  we can remember this as Collections.RBS
 *  
 *  Arrays.sort(arrayName, startIndex, endIndex)---when we want to sort only few elements
 *
 */
public class CompareArrays {
public static void main(String[] args) {
	int[] a=new int[2];

	int[] b= new int[3];
	
    if(Arrays.equals(a,b)){
    	System.out.println(""+true);
    }
    else{
    	System.out.println("not equal");
    }
}
	
}
