package StringExamples;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringPermutationsAlt {


    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please enter a String ");
        String input=scanner.next();
        System.out.println("Please enter another String ");
        String secondStr=scanner.next();
        boolean ans=false;
        ans=printPermutations(input, secondStr,"", ans);
        System.out.println(ans);
    }

    private static boolean printPermutations(String input, String s2, String asf, boolean ans) {
        if(input.length()==0){
            if(s2.contains(asf)){
                ans=true;
                return ans;
            }
        }

        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            String leftQuestion=input.substring(0,i);
            String rightQuestion=input.substring(i+1);
            String question=leftQuestion+rightQuestion;
            ans=printPermutations(question, s2, asf+ch, ans);
        }

    return ans;
    }
}
