package java8;

import java.util.Scanner;
import java.util.function.Predicate;

public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Please enter a String ");
        String input = sc.nextLine();
        System.out.println(checkValidString(input));

    }

    private static boolean checkValidString(String input) {
        Predicate<String> stringPredicate=(s)->s.startsWith("checkpoint");
        return stringPredicate.test(input);


    }

}
