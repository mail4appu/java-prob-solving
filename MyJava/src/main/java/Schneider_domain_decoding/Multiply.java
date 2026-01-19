package Schneider_domain_decoding;

import java.util.Arrays;

public class Multiply {

    public static void main(String[] args) {
        int nums[] = {2, 3, 4, 5, 6};
        int current;
        for (int i = 0; i < nums.length; i++) {
            int result = 0;

            if (i == 0){
                result = nums[i - 1] * nums[i + 1];
             }
            else if(i==nums.length){
                result=nums[i]*nums[i-1];
            }
            else{
                result=nums[i-1]*nums[i+1];
            }

            current = nums[i];
            nums[i] = result;


        }
        System.out.println(Arrays.toString(nums));

    }
}
