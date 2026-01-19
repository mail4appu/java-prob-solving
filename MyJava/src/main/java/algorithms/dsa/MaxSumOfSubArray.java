package algorithms.dsa;

public class MaxSumOfSubArray {
    public static void main(String[] args) {
        int[] arr= {2,1,5,1,3,2};
        int k=3;
        int maxSum=0, windowSum=0;
        for(int i=0;i<arr.length;i++){
            windowSum+=arr[i];

            if(i>=k-1){
                maxSum=Math.max(maxSum, windowSum);
                windowSum-=arr[i-k+1];
            }
        }
        System.out.println("Max sum of size "+k+"= "+maxSum);
    }
}
