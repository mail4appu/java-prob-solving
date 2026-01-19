package java8.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListStream {
    public static void main(String[] args) {
        List<String> places = Stream.of("Vizag", "Bangalore", "Hyderabad").collect(Collectors.toList());
        places.add("Pune");
        String[] names = {"Appu", "Nivi", "Poori"};
        Arrays.stream(names).filter(name -> name.startsWith("A"));

        List<Integer> numbers = IntStream.range(1, 10).boxed().collect(Collectors.toCollection(ArrayList::new));

        places.stream().forEach(System.out::println);
    }
}
