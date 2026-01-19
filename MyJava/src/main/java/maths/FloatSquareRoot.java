package maths;

import java.util.Scanner;

public class FloatSquareRoot {
    public static void main(String[] args) {
        System.out.println("Please enter a valid number");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        System.out.println("Please enter precision");

        int precision = sc.nextInt();
        double result = findSquareRoot(number, precision);
        System.out.println(result);
    }



    static double  findSquareRoot(double number, int pre) {
        double start = 1;
        double end = number;
        //This returns 0.01 when pre is 2
        double precision = Math.pow(10, -pre);
        double ans = 1;

        while (start <= end) {
            double mid = (start + end) / 2;
            ans = mid;

            // if the difference between square of current mid and number is less than pre
            // value, then break.
            double midSquare = mid * mid;
            if (Math.abs(midSquare - number) <= precision)
                break;

                // decrementing end if answer lies between current start and mid
            else if (midSquare > number)
                end = mid;

                // incrementing end if answer lies between mid and current end.
            else
                start = mid;
        }
        //return Math.round(ans * Math.pow(10, precision)) / Math.pow(10, precision);
        return ans;
    }

}
