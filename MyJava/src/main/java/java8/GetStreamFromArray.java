package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream is a view only but not any container or data structure
 * Any changes made on stream can not reflect on original data structure
 */
public class GetStreamFromArray {
    public static void main(String[] args) {
        String[] input={"s","c", "h","n","e","i","d","e","r"};
        List<String> names= Arrays.asList("appu","poori", "Bujjamma","sneha");
        System.out.println(names);
        final List<String> collect = names.stream().map(x -> x.toUpperCase()).collect(Collectors.toList());
        System.out.println(collect);

        //Array to Stream
        Stream<String> stream = Arrays.stream(input);
        stream.map(i->i.concat("s")).forEach(System.out::println);
        //Stream of indices ( indexes )
        IntStream indicesStream = IntStream.range(0, input.length);
       // indicesStream.forEach(i-> System.out.println(i));
       // indicesStream.mapToObj(index->""+index+"->"+input[index]).forEach(System.out::println);
        indicesStream.mapToObj(index->String.format("%d->%s", index,input[index])).forEach(System.out::println);
    }
}
