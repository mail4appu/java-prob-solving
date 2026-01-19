package algorithms;

import java.util.Scanner;

public class PrintDecreasingIncreasing {
    public static void main(String[] args) {
        System.out.println("Please enter a positive value");
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();

        pdi(n);
    }

    private static void pdi(int n) {
        if(n==0)
            return;

        System.out.println(n);
         pdi(n-1);
        System.out.println(n);
    }
}
