

package algorithms.Strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Words having same charactes
 * Example: LISTEN & SILENT
 *
 *
 * This is old school technique
 * see and strike  character
 *
 * Here also the same logic ==> Just assign empty character i.e 0 after the character is traversed
 *
 *
 */
public class CheckAnagramOrNot {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter first String");
        String first = sc.next();
        sc.nextLine();
        System.out.println("Enter sec String");
        String second = sc.next();
        sc.nextLine();
        checkAnagram(first,second);

    }

    private static void checkAnagram(String first, String second) {
        char[] f = first.toCharArray();
        char[] s=second.toCharArray();
        for(char c:f){
            int i = second.indexOf(c);
            if(i==-1){
                /*s[i]='0'; //Assigning empty char ..How interesting here it is
                System.out.println(s[i]);*/
                System.out.println("Not an anagran");
                return;
            }
        }
       /* System.out.println(Arrays.toString(s));
        for(char c:s){
            if(c!='0'){
                System.out.println("Not anagram");
                return;
            }
        }*/
        System.out.println("Yes anagram");

    }
}
