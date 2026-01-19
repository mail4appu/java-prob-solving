package algorithms.heaps;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Time complexity of this is O(nlogn)
 * n-being the size of array
 * heapify() operation complexity is hieght complexity which is logn
 * For all elements we perform this
 *
 * hence O(nlogn)
 */
public class HeapConstructionBruteForce {
    public static void main(String[] args) {
        System.out.println("Please enter array size");
        Scanner scanner= new Scanner(System.in);
        int size=scanner.nextInt();
        System.out.println("Please enter array elements");
        int[] input= new int[size];
        for(int i=0;i<size;i++){
            input[i]=scanner.nextInt();
        }
        scanner.nextLine();
        buildHeap(input);
    }

    private static void buildHeap(int[] input) {

        for(int i=1;i<input.length;i++){
            heapiFy(input, i);


        }
        System.out.println(Arrays.toString(input));
    }

    private static void heapiFy(int[] input, int i) {
        int parentIndex=(i -1)/2;
        if(input[i]> input[parentIndex]){
            swap(i, parentIndex, input);
            if(parentIndex!=0){
                heapiFy(input, parentIndex);
            }
        }
    }

    private static void swap(int currentIndex, int parentIndex, int[] input) {
        int tmp=input[currentIndex];
        input[currentIndex]=input[parentIndex];
        input[parentIndex]=tmp;
    }
}
