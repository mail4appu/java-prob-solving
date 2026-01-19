package algorithms.sorting;

/**
 * @author apparao
 * 
 *  *****method variables are local and are created/destroyed during method entry and exit.*******
 *  
 *  Here the mergeSort(first) call is method to itself.
 *  
 *  so the call runs in a different stack(method area in stack memory), where the first and second variables are local to that stack only. not to the original mergeSort() method.
 *  
 *  the inner stack varibles are created and destroyed during inner stack only. That does not effect outer stack variables 
 *  
 *  We can visualize this recursive call as copy of the original method. 
 *  
 *  All recursive method calls are the copy of the original methods. ie. recursive method call runs in a separate stack area/method area with the same code
 *  
 *  
 *  This recursion is used in many places.
 *  While calculating the factorial, fibonacci series and permutations of a string etc
 *  
 *  
 *  tme complexity of this algorithm is 0(nlogn)..here  n being the size of given array
 * 
 *
 */
public class MergeSort {
	
	
	public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }
        
        // Split the array in half
        int[] first = new int[list.length / 2];
        int[] second = new int[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        
        // Sort each half
        mergeSort(first);
        mergeSort(second);
        
        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }
    
    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int i = 0;
        // Next element to consider in the second array
        int j = 0;
        
        // Next open position in the result
        int k = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (i < first.length && j < second.length) {
            if (first[i] < second[j]) {
                result[k] = first[i];
                i++;
                } else {
                result[k] = second[j];
                j++;
            }
            k++;
        }
        // copy what's left
        System.arraycopy(first, i, result, k, first.length - i);
        System.arraycopy(second, j, result, k, second.length - j);
    }
    
    
    
    
    
    public static void main(String args[]) throws Exception
    {
        String list="";
        int i=0,n=0;
        int elementlist[]  = new int[]{3, 8, 9, 4, 2, 1};
        elementlist=mergeSort(elementlist);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Values after Merge Sort : ");
        for (int j=0;j<elementlist.length;j++) {
            System.out.println(elementlist[j]+" ");
        }
}
}

    