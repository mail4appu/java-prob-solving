package algorithms.dsa;

import java.util.Arrays;

public class ProductExeptItself {

    public static void main(String[] args) {
        int nums[] = new int[]{1, 2, 3, 4};
        int result[] = new int[nums.length];

        int currentProd = 1;
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            currentProd = currentProd * nums[i - 1];
            result[i] = currentProd;
        }

        currentProd = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            currentProd = nums[i + 1] * currentProd;
            result[i] *= currentProd;
        }
        System.out.println(Arrays.toString(result));

    }


}
