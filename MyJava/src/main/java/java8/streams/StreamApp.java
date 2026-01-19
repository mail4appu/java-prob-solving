package java8.streams;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApp {
    public static void main(String[] args) {
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            final List<Person> persons = objectMapper.readValue("[\n" +
                    " {\"name\":\"Apparao\", \"emailId\":\"mail4appu@gmail.com\", \"city\":\"Visakhapatnam\", \"dob\":\"1987-12-28:18:26:26\", \"age\":32},\n" +
                    " {\"name\":\"Poorna\", \"emailId\":\"bpoorna@gmail.com\", \"city\":\"Visakhapatnam\", \"dob\":\"1994-05-22:14:26:62\", \"age\":27},\n" +
                    " {\"name\":\"Bujjamma\", \"emailId\":\"bujjamma@gmail.com\", \"city\":\"Visakhapatnam\", \"dob\":\"2016-04-28:18:23:49\", \"age\":4},\n" +
                    " {\"name\":\"Sneha\", \"emailId\":\"ysnehatha@gmail.com\", \"city\":\"Visakhapatnam\", \"dob\":\"2003-07-30:18:26:45\", \"age\":17},\n" +
                    " {\"name\":\"Satya\", \"emailId\":\"satya0042@gmail.com\", \"city\":\"Hyderabad\", \"dob\":\"1989-11-23:11:22:59\", \"age\":30}\n" +
                    "]\n", new TypeReference<List<Person>>() {});
            System.out.println("No of persons: "+persons.size());

            final Person eldestPerson = persons.stream().max(Comparator.comparing(x -> x.getAge())).get();
            final Person youngestPerson=persons.stream().min(Comparator.comparing(x->x.getAge())).get();
            System.out.println("eldest person: "+eldestPerson+" \n Youngest Person: "+youngestPerson);
            persons.stream().filter(person -> person.getAge()>20).collect(Collectors.toList());
            persons.stream().map(person -> {
                person.setCity("Vizag");
                return person;
            }).collect(Collectors.toList());


            //Sum on any stream can be done using reduce
            final Double total = Stream.of(1.3, 4.5, 6.7, 8.99, 78.45).reduce(0.0, (Double a, Double b) -> a + b);
            System.out.println(total);

            //sum() method can be used only on int streams but not on all streams
            System.out.println(IntStream.range(1, 10).sum());
            System.out.println(Stream.of("hi", "bye").map(x -> "123" + x).collect(Collectors.joining(",")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
