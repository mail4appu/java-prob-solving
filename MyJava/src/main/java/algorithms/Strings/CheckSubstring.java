package algorithms.Strings;

import java.util.Scanner;

/**
 * Finding substring without using java apis
 */
public class CheckSubstring {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter first String");
        String first = sc.nextLine(); //Accepting string with "Enter"
        System.out.println("Enter sec String");
        String second = sc.nextLine();
        //checkSubString(first,second);
        checkSubstringII(second,first);
    }

    private static void checkSubString(String orignal, String str) {
        char[] orig=orignal.toCharArray();
        char[] st=str.toCharArray();
        int counter=0;
        for(char o:orig){
            if(o==st[counter]){
                counter++;
            }
            else{
                counter=0;
            }
            if(counter==str.length()){
                System.out.println("yes substring exists");
                return;
            }
        }
        System.out.println("no substring");

    }

    public static void checkSubstringII(String s2, String s1){
        int counter = 0; //pointing s2
        int i = 0;
        for(;i<s1.length();i++){
            if(counter==s2.length()) {
                break;
            }
            if(s2.charAt(counter)==s1.charAt(i)){
                counter++;
            }else{
                //Special case where character preceding the i'th character is duplicate
                if(counter>0){
                    i--;
                }
                counter = 0;
            }
        }
        System.out.println("found @ index "+(counter < s2.length()?-1:i-counter));
    }
}
