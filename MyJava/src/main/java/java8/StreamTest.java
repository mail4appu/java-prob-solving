package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;



/**
 * Function - method takes input (No of arguments do not matter) and returns something
 * Predicate - A method takes input and returns boolean
 * Consumer - A method taken input and returns nothing
 * Supplier - A method takes no input but returns something
 */
public class StreamTest {

    public static void main(String[] args) {

        IntStream intStream = IntStream.of(10, 20, 30);
        List<Integer> integerList= new ArrayList<>();
        integerList.add(30);
        integerList.add(20);

        integerList.forEach(i->{
            System.out.println("each value"+i);
            if(isOddNumber(i)){
                System.out.println("it is odd");
            }

        });


    }

    private static boolean isOddNumber(Integer i) {
        return i%2==0;
    }
}
