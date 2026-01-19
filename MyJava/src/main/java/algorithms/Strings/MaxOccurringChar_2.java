package algorithms.Strings;

import java.util.Arrays;
import java.util.Scanner;

public class MaxOccurringChar_2 {
    public static void main(String[] args) {
        System.out.println("Enter string");
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        maxOccurring(s.toCharArray());
    }

    private static void maxOccurring(char[] inputArray) {
        int freq[] = new int[26];
        for(int i=0;i<inputArray.length;i++){
            if(inputArray[i]!=' '){
                int j=inputArray[i]-'a';
                freq[j]=freq[j]+1;


            }
        }
        System.out.println(Arrays.toString(freq));
    }
}
