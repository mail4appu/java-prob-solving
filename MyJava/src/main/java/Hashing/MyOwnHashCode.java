package Hashing;

import java.util.Scanner;

/**
 * If we add just ascii codes of each character in a string
 *  hashcode of "foo" and "oof" and "ofo" will be same
 *
 *  Hashcode should be unique for each string
 *
 *  If we clearly observer above strings, though letters in each word are same,  position of each character is different among the give 3 strings
 *  so the trick is to use the position and calculate unique hashcode
 *
 *  Lets take a prime number ( preferably 31 ) and raise the chosen prime number to chosen character's position
 *
 *  (31^0)*Ascci_1+ (31^1)*Ascii_2+(31^2)*Ascii_3+.......(31^len-1)*Ascii_n-1
 *
 *
 */
public class MyOwnHashCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a string");
        String str = sc.nextLine();
        System.out.println(str);
        System.out.println(findHashCode(str));


    }

    private static int findHashCode(String str) {
        char[] chs = str.toCharArray();
        int k = 31;
        int hashCode = 0;
        for (int i = 0; i < chs.length; i++) {
            int ch = chs[i]; //Ascii code of each char
            hashCode = hashCode + ((int) Math.pow(k, i) * ch);   // Unique hashcode generation
        }
        return hashCode;
    }
}
