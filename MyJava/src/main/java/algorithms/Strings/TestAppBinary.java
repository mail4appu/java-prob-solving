package algorithms.Strings;

import java.util.Scanner;

public class TestAppBinary {
    public static void main(String[] args) {
        System.out.println("Enter a String");
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();
        str.indexOf("c");

        System.out.println(str.charAt(FirstRepeated(str)));
    }


    static int FirstRepeated(String str)
    {
        // An integer to store presence/absence
        // of 26 characters using its 32 bits.
        int checker = 0;

        for (int i = 0; i < str.length(); i++)
        {
            int val = (str.charAt(i)-'a');
            System.out.println("Value:  "+val);

            // If bit corresponding to current
            // character is already set

            System.out.println("if:  " + Integer.toBinaryString((checker & (1 << val))));
            if ((checker & (1 << val)) > 0) {
                return i;
            }

            // set bit in checker
            checker |= (1 << val);
            System.out.println("Checker:  "+"  :  "+checker+"  :   "+Integer.toBinaryString(checker));
            System.out.println("=======================");
        }

        return -1;
    }

}
