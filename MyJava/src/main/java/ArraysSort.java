import java.util.Arrays;




public class ArraysSort {
	 public static void main(String args[])
	  {			                // SORTING INT ARRAY
	    int numbers[] = { 90, 10, 50, 60, 30, 40, 20, 80, 70 };
	    
	    System.out.println("Before sort numbers: " + Arrays.toString(numbers));
	   //
	    Arrays.sort(numbers);
	    System.out.println("search index is"+Arrays.binarySearch(numbers, 70));
	    
	    System.out.println("after sort numbers: " + Arrays.toString(numbers));
	   /* Arrays.sort(numbers);
	    System.out.println("After sort numbers: "  + Arrays.toString(numbers));
	 
			                        // SORTING FEW ELEMENTS
	    int numbers1[] = { 9, 1, 5, 6, 3, 4, 2, 8, 7 };
	    System.out.println("\nBefore sort numbers1: " +  Arrays.toString(numbers1));
	 
	    Arrays.sort(numbers1, 2, 7);//2--inclusive index, 7-exclusive index
	    
	    System.out.println("After sort 2 to 7 numbers1:"  + Arrays.toString(numbers1));*/
	  }

}
