package algorithms;

import java.util.Scanner;

public class SumOfTwoNumbers {

    public static void main(String[] args) {
        System.out.println("Enter first number");
        Scanner sc= new Scanner(System.in);
        int i1=sc.nextInt();sc.nextLine();
        System.out.println("Enter Second number");
        int i2=sc.nextInt();
        computeAdd(i1,i2);
    }

    private static void computeAdd(int x, int y) {
        int temp=0;
        int carry=0;
        StringBuffer sb= new StringBuffer("");

        while(true){
            temp=(x%10)+(y%10)+carry;
            carry=temp/10;
            x=x/10;
            y=y/10;
            sb.append(temp%10);
            if(x==0 && y==0){
                sb.append(carry);
                break;
            }

        }
        System.out.println(sb.reverse());
    }
}
