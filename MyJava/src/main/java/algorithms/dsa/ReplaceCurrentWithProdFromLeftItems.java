package algorithms.dsa;

import java.util.Arrays;
import java.util.Scanner;

public class ReplaceCurrentWithProdFromLeftItems {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter array Size");
        int size=sc.nextInt();
        System.out.println("Enter array elements");
        int nums[]= new int[size];
        for(int i=0;i<size;i++){
            nums[i]=sc.nextInt();
        }
        productFromLeft(nums);
    }

    private static void productFromLeft(int[] nums) {
        int size=nums.length;
        int prodSoFar=1;
        int temp=1;
        for(int i=0;i<size;i++){
            prodSoFar*=temp;
            temp=nums[i];
            nums[i]=prodSoFar;
        }
        System.out.println(Arrays.toString(nums));

    }
}
