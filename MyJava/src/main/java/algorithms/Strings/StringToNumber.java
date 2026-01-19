package algorithms.Strings;

import java.util.Scanner;

public class StringToNumber {
    public static void main(String[] args) {
        System.out.println("Enter a String");
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();
        convertStringToInt(str);
    }

    private static void convertStringToInt(String str) {
        char[] chars = str.toCharArray();
        int sum=0;
        for(char ch:chars){
            int temp=ch;
            System.out.println('0');
            System.out.println(temp);
            sum=(sum*10)+temp;
        }
        System.out.println(sum);
    }
}
