package maths;

import java.util.Scanner;

public class DivideTwoIntegersWithoutDivision {
    public static void main(String[] args) {
        System.out.println("Please enter dividend");
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt();

        System.out.println("Please enter divisor");

        int divisor = sc.nextInt();
        int result=devideTwoIntegers(dividend, divisor);
        System.out.println(result);
    }

    private static int devideTwoIntegers(int dividend, int divisor) {

     return getCount(dividend, divisor, 0);
    }


    private static int getCount(int dividend, int divisor, int result){
        if(dividend==divisor){
            return result+1;
        }
        if(dividend<divisor){
            return result;
        }
        int count=0;
        int temp=divisor;
        while(temp<=dividend){
            count++;
            temp=divisor<<count;
        }
        result=result+(1<<count-1);
        temp=temp>>1;
         int mid=Math.abs(temp-dividend);
        if(mid>=divisor){
           result=getCount(mid, divisor, result);
        }
      return result;
    }
}
