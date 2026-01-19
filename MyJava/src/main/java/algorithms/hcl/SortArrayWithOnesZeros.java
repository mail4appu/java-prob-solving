package algorithms.hcl;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Technique is very simple
 * Take two pointers
 * if non zero ,
 *     swap + increment both pointers
 * else
 *     just increment second pointer
 *
 */
public class SortArrayWithOnesZeros {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter size");
        int size = scanner.nextInt();
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i] = scanner.nextInt();
        }
        scanner.nextLine();
        sortArray(input);
    }

    private static void sortArray(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; ) {

            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else {
                j++;
            }
            System.out.println("Array is"+Arrays.toString(nums));

        }

        System.out.println(Arrays.toString(nums));
    }
}
