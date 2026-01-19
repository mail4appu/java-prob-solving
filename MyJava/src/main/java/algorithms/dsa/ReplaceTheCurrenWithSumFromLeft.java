package algorithms.dsa;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Exclude the current element
 *
 * Simple Trick, where ever exclusion of current element is required
 * hold the current element in temp varrable
 *
 *
 * Enter array Size
 * 5
 * Enter array elements
 * 2 1 5 6 4
 * [0, 2, 3, 8, 14]
 *
 *
 */
public class ReplaceTheCurrenWithSumFromLeft {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter array Size");
        int size=sc.nextInt();
        System.out.println("Enter array elements");
        int nums[]= new int[size];
        for(int i=0;i<size;i++){
            nums[i]=sc.nextInt();
        }
        sumFromLeft(nums);
    }

    private static void sumFromLeft(int[] nums) {
        int sumSoFar=0;
        int temp=0;

        for(int i=0;i<nums.length;i++){
            sumSoFar+=temp;
            temp=nums[i];
            nums[i]=sumSoFar;
        }
        System.out.println(Arrays.toString(nums));
    }
}
