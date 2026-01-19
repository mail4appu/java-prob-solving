package algorithms.Strings;

import java.util.Scanner;

public class RemoveDuplicatesInaString {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter  String");
        String first = sc.nextLine(); //Accepting string with "Enter"
        removeDuplicates(first);
    }

    /**
     * @param first
     *
     * This is just like using hashset
     *  i.e using extra space
     *  but kind of using our own array space instead of using java defined library
     */
    private static void removeDuplicates(String first) {
        char[] array=new char[26];
        char[] chars = first.toCharArray();
        for(char ch:chars){
            int temp=ch-'a';
            array[temp]=ch;
        }
        for(char ch:array){
            if(ch!=0){ //Here comparing Ascii
                System.out.print(ch);
            }
        }
    }

}
