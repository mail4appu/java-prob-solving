package maths;

import java.util.Scanner;

public class IntSquareRoot {
    public static void main(String[] args) {
        System.out.println("Please enter a valid number");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int result = findSquareRoot(number);
        System.out.println(result);
        System.out.println(Math.pow(10, -2));
    }

    private static int findSquareRoot(int number) {
        if (number == 0 || number == 1) {
            return number;
        }

        int start = 1;
        int end = number;
        while (start <= end) {
            int mid = (start + end) / 2;
            int midSquare = mid * mid;
            if (midSquare == number) {
                return mid;
            }
            if (midSquare < number) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        return end;
    }
}
