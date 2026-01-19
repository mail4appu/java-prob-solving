package algorithms;

import java.util.Scanner;

/**
 * This is a bruteforce approach
 *  For infinity,  max value from the given array becomes floor
 *  -> for max value, second max becomes floor--> like wise
 *
 *
 *  so floor(int[] input, INTEGER_MAX_VALUE), should return max from array
 *
 *
 *
 * For -infinity, min value from an array becomes ceil
 *
 *  Floor of max value in an array  is 2nd max
 *  Floor of 2nd max value in an array is 3rd max .....like wise
 *
 *
 *  TimeComplexity O(kn)
 *
 *
 */
public class FindKthLargestInAnUnsortedArray {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter Array Size");
        int n=sc.nextInt();
        int[] input= new int[n];
        for(int i=0;i<n;i++){
            input[i]=sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Enter k value");
        int k=sc.nextInt();
        findKthLargest(input, k);

    }

   static int  floor=Integer.MIN_VALUE;
    private static void findKthLargest(int[] input, int k) {
        int ceil=Integer.MAX_VALUE;
        
        for(int i=0;i<k;i++){
            floor(input, ceil);
            ceil=floor;
            floor=Integer.MIN_VALUE;

        }
        System.out.println("kth largest is:   "+ceil);
    }

    private static void floor(int[] input, int ceil) {
        for(int val:input){
            if(val<ceil){
                if(val>=floor){
                    floor=val;
                }
            }
        }
        System.out.println("Floor value is "+floor);
    }
}
