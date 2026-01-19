package java8;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStreams {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        IntStream.range(0,1000).forEach(System.out::println);
        System.out.println("Plain stream took "+(System.currentTimeMillis()-start));

        long startParallel=System.currentTimeMillis();
        IntStream.range(0,1000).parallel().forEach(System.out::println);
        System.out.println("Parallel stream took "+(System.currentTimeMillis()-startParallel));

       // list.stream().filter(i->i%2==0).forEach(System.out::println);

    }



}
