package algorithms.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesUsingBitwise {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter  String");
        String first = sc.nextLine(); //Accepting string with "Enter"
        removeDuplicates(first);
    }

    private static void removeDuplicates(String first) {
        int counter=0;
        char input[]=first.toCharArray();
        int temp=0;
        int resultStrLength=0;
        int ascii=0;
        while (temp < input.length) {
            ascii=input[temp]-'a';
            if((counter & (1 << ascii))==0){
                input[resultStrLength]=(char)('a'+ascii);
                counter=counter | (1 << ascii);
                resultStrLength++;
            }
            temp++;

        }
        char[] chars = Arrays.copyOfRange(input, 0, resultStrLength);
        System.out.println(chars);
    }
}
