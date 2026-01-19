package algorithms.dsa;

public class MaxProductSubArray {
    public static void main(String[] args) {
        int[] arr=new int[]{2,-5,-2,-4,3};
        System.out.println(maxProduct(arr));



    }

    public static int maxProduct(int[] nums) {

        int maxSoFar=nums[0];
        int maxEnding=nums[0];
        int minEnding=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int temp=maxEnding;
                maxEnding=minEnding;
                minEnding=temp;
            }
            maxEnding=Math.max(nums[i], maxEnding*nums[i]);
            minEnding=Math.min(nums[i], minEnding*nums[i]);
            maxSoFar=Math.max(maxEnding, maxSoFar);

        }
        return maxSoFar;


    }
    public static void swap(int maxEnding, int minEnding){


    }
}
