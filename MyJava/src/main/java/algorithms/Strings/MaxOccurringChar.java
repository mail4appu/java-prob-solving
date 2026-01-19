package algorithms.Strings;

import java.util.Scanner;

public class MaxOccurringChar {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter  String");
        String first = sc.nextLine(); //Accepting string with "Enter"
        maxOccuringCharacter(first);
    }

    private static void maxOccuringCharacter(String str1) {
        int ctr[] = new int[26];
        int l = str1.length();
        for (int i = 0; i < l; i++) {
            char c = str1.charAt(i);
            ctr[c-'a']=ctr[c-'a']+1;
        }
        int max = -1;
        char result = ' ';

        for (int i = 0; i < l; i++) {
            if (max < ctr[str1.charAt(i)-'a']) {
                max = ctr[str1.charAt(i)-'a'];
                result = str1.charAt(i);
            }
        }
        System.out.println(result);
    }
}
