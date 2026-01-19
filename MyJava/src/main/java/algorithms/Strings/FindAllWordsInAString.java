package algorithms.Strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAllWordsInAString {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter  String");
        String first = sc.nextLine(); //Accepting string with "Enter"
        findAllWords(first);
    }

    /**
     * @param first
     *  Find words that match the pattern
     *  i.e here is a tricky way of finding words in a string without using split
     *
     */
    private static void findAllWords(String first) {
        Pattern p= Pattern.compile("[a-zA-Z]+");
        Matcher matcher = p.matcher(first);
        while(matcher.find()){
            System.out.println(matcher.group());
        }

    }
}
