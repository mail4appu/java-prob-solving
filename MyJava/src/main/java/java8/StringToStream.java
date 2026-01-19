package java8;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * string.chars() return assci value stream
 *
 * mapToObj is strictly meant for type conversion and map can not achieve the same
 */
public class StringToStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Plese enter any String");
        String input=sc.nextLine();  //input.chars()==> converting to int stream
        //Converting to stream of ints and printing
        input.chars().forEach(ch-> System.out.println(ch));
        //Converting to Stream of chars
        input.chars().mapToObj(x->(char)x).forEach(x-> System.out.println("after conversion \n"+x));

        IntStream intStreamUsingCodePoints = input.codePoints();
        System.out.println("Using code pints-- int stream ");
        intStreamUsingCodePoints.forEach(i-> {

            System.out.print(i+" ");
        });

        //Convert to char stream using codePoints
        System.out.println("\nChar stream using Code points");
        input.codePoints().mapToObj(i->(char)i).forEach(ch-> System.out.println(ch));

        //Convert to single character String stream i.e "m" "y" i.e not as chars but strings for single character

        System.out.println("Single character string ");
        input.codePoints().mapToObj(i->String.valueOf((char)i)).forEach(j-> System.out.println(j));

        String numInput="99999999";
        numInput.chars().anyMatch(ch -> (int) (ch - '0') != 9);


    }
}
