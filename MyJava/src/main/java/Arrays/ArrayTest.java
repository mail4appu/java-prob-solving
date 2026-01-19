package Arrays;

import java.util.Arrays;
/**
 * @author vapparao
 * 
 * Default sorting order with sort() method is ascending
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
 * 
 *  
 *  one more important method 
 *  Collections.reverseOrder()--> returns compartor object
 *  
 *   Collections.sort(list, compObj)--if we want to sort in reverse order i.e descending use above line's object
 *  
 *
 */
public class ArrayTest {
public static void main(String[] args) {
	Object[] a= new Object[10];
	a[0]="abc";
	a[1]=new Integer(1);
	a[5]="bbc";
	System.out.println("array is: "+Arrays.toString(a));// [abc, 1, null, null, null, null, null, null, null, null]
}
}
