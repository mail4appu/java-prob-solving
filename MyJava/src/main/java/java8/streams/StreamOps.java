package java8.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOps {
    public static void main(String[] args) {
        final Integer sum = Stream.of(1, 2, 3, 4, 5).reduce(0, (a, b) -> a + b);
        System.out.println("sum of the given int stream:  "+sum);
        Integer maxValue = Stream.of(10, 20, 30, 40).max(Integer::compareTo).get();
        System.out.println("Max value of the int Stream:  "+maxValue);
        final Double sumOfFloat = Stream.of(11.2, 5.7, 6.4, 7.89).reduce(0.0, (a, b) -> a + b);
        System.out.println(sumOfFloat);

        int sumRange = IntStream.range(1, 101).reduce(0, (a, b) -> a + b);
        System.out.println("Sum of range "+sumRange);


        //Group by first character in the string
        final Map<Character, List<String>> collect = Stream.of("Appu", "Anand", "Bujjamma", "Bhaskar", "Poorna", "Pavitra", "Palani","Zaved", "Dravid", "Emma", "Dhriva").collect(Collectors.groupingBy(x -> x.charAt(0)));
        System.out.println(collect);

        Map<Integer, List<String>> idNPhones= new HashMap<>();
        idNPhones.put(432, Stream.of("9535359918", "7996440919").collect(Collectors.toList()));
        idNPhones.put(12, Stream.of("9535350018", "7996440818").collect(Collectors.toList()));
        idNPhones.put(1, Stream.of("9535350018", "7996440818").collect(Collectors.toList()));
        idNPhones.put(51, Stream.of("9535350018", "7996440818").collect(Collectors.toList()));
        idNPhones.put(514, Stream.of("9535350018", "7996440818").collect(Collectors.toList()));

        Stream<Map.Entry<Integer, List<String>>> sorted = idNPhones.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey));
        //LinkedHashMap<Integer, List<String>> sortedIdNPhones = idNPhones.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue(), (item1, item2) -> item1, LinkedHashMap::new));
        sorted.forEach(item->{
            System.out.println(item.getKey()+" :  "+item.getValue());
        });


       // System.out.println(idPhonesSet.size());
    }
}
