package algorithms.dsa;

import java.util.Arrays;

/**
 * [4,8,6,1,14,7,3]
 * [32, 24, 8, 84, 7, 42, 21]
 *
 *
 * if no next or previous, multiply with itself
 *
 *
 */
public class ReplaceCurrentWithProdOfNextNPrevious {

    public static void main(String[] args) {

        int nums[]={4,8,6,1,14,7,3};
        int size=nums.length;
        int temp=nums[0];
        for(int i=0;i<size;i++){
            if(i==size-1){
                nums[i]=temp*nums[i];
                break;
            }
          int result=temp*nums[i+1];
          temp=nums[i];
          nums[i]=result;


        }
        System.out.println(Arrays.toString(nums));
    }


}
