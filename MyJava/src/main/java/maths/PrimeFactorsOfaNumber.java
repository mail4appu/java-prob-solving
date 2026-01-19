package maths;

import java.util.Scanner;

/**
 * Example : 1258
 *
 * Time complexity O(sqrt(n))
 *
 * This is old school technology
 *    |1258
 *   2|------
 *    |629
 *  17|--------
 *      37
 *
 *    Here as 37, is prime number, no more factors
 *    This way we always end up with prime factors
 *
 *    As we know, factors of number can not go beyond half of the number
 *
 */
public class PrimeFactorsOfaNumber {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Please enter a number");
            Scanner sc = new Scanner(System.in);
            int number = sc.nextInt();
            sc.nextLine();
            findPrimeFactors(number);
        }

    }

    private static void findPrimeFactors(int number) {
        for(int i=2;i*i<number;i++){
            while(number%i==0){
                System.out.println(i);
                number=number/i;
            }
        }
        if(number!=1){
            System.out.println(number);
        }
    }
}
