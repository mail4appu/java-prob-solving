package algorithms.dsa;

import java.util.Scanner;

public class PrintSubSequence {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please enter a string ");
        String input=scanner.next();
        printSubsequence(input, "");
    }

    private static void printSubsequence(String input, String ans) {
        if(input.length()==0){
            System.out.println(ans);
            return;
        }

            char ch=input.charAt(0);
            String question=input.substring(1);
            printSubsequence(question, ans+ch);
            printSubsequence(question, ans);

    }
}
