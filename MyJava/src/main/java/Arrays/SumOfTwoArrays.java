package Arrays;

import java.util.Scanner;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(); //Accepts until space only
        int[] input1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            input1[i] = sc.nextInt();
        }
        int n2 = sc.nextInt();
        int[] input2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            input2[i] = sc.nextInt();
        }

        int[] sum = new int[n1 > n2 ? n1 : n2];
        //Start from the end  (Like old school)
        int i = input1.length - 1;
        int j = input2.length - 1;
        int k = sum.length - 1;
        //Carry
        int carry = 0;


        while (k >= 0) {
            //midSum is the sum of digits from right
            int midSum = carry;
            if (i >= 0) {
                midSum += input1[i];

            }
            if (j >= 0) {
                midSum += input2[j];
            }
            midSum = midSum % 10;
            carry = midSum / 10;
            sum[k] = midSum;

            i--;
            j--;
            k--;
        }

        //This is the trick to print sum
       if(carry!=0){
           System.out.print(carry);
       }
       for(int val:sum){
           System.out.print(val);
       }
    }

}
