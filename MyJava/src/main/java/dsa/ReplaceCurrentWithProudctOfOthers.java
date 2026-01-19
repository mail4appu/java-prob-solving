package dsa;

import java.util.Arrays;
import java.util.Scanner;

/**
 * This problem can not be solved in constant space
 * We need extra space.
 */
public class ReplaceCurrentWithProudctOfOthers {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.println("Enter array Size");
        int size=sc.nextInt();
        int nums[]= new int[size];
        for(int i=0;i<size;i++){
            nums[i]=sc.nextInt();
        }
       productOfOthers(nums);

    }

    private static void productOfOthers(int[] nums) {
        int size=nums.length;
        int left[]=new int[size];
        int right[]= new int[size];
        //Find product so far in the left direction excluding the current element
        int prodSoFar=1;
        for(int i=0;i<size;i++){
            left[i]=prodSoFar;
            prodSoFar=prodSoFar*nums[i];

        }
        //Find product so far in the right direction excluding the current element
        prodSoFar=1;
        for(int i=size-1;i>=0;i--){
            right[i]=prodSoFar;
            prodSoFar=prodSoFar*nums[i];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        for( int i=0;i<nums.length;i++){
            nums[i]=left[i]*right[i];

        }
        System.out.println(Arrays.toString(nums));

    }

}