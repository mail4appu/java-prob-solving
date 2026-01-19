package algorithms.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsequnces {
    public static void main(String[] args) {
        System.out.println("Please enter a string ");
        Scanner sc= new Scanner(System.in);
        String str=sc.nextLine();
        List<String> ssList=new ArrayList<>();
        ss(str,"", ssList);
        System.out.println(ssList.size());


    }

    private static void ss(String str, String ans, List<String> ssList) {
        if(str.length()==0){
            ssList.add(ans);
            return;
        }

        char ch=str.charAt(0);
        String ros=str.substring(1);
        ss(ros,ans+"", ssList);
        ss(ros, ans+ch, ssList);

    }
}
