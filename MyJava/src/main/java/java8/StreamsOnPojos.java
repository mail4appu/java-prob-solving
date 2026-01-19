package java8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Collectors.toMap(x->x.g, x->x.get)
 */
public class StreamsOnPojos {

    public static void main(String[] args) {
        ObjectMapper objectMapper= new ObjectMapper();
        try {
            List<Product> productList= objectMapper.readValue("[{\"name\":\"Lenovo Think pad X1-Carbon\",\"description\":\"string\",\"price\":\"3000$\",\"type\":\"high-end\",\"os\":\"Windows\"},{\"name\":\"Macbook-pro-2020\",\"description\":\"string\",\"price\":\"4000$\",\"type\":\"high-end\",\"os\":\"ios\"},{\"name\":\"Lenovo Think pad T540\",\"description\":\"high end laptop\",\"price\":\"3000$\",\"type\":\"high-end\",\"os\":\"Windows\"},{\"name\":\"Macbook-air\",\"description\":\"string\",\"price\":\"2000$\",\"type\":\"high-end\",\"os\":\"ios\"},{\"name\":\"Lenovo Think Book\",\"description\":\"Medium end laptop\",\"price\":\"1500$\",\"type\":\"medium-end\",\"os\":\"Windows\"},{\"name\":\"Dell latitude\",\"description\":\"Windows\",\"price\":\"1000$\",\"type\":\"Medium-end\",\"os\":\"Windows\"},{\"name\":\"Lenovo Yoga Book\",\"description\":\"Medium end laptop\",\"price\":\"1500$\",\"type\":\"medium-end\",\"os\":\"Windows\"},{\"name\":\"Dell Inspiron\",\"description\":\"Windows\",\"price\":\"1200$\",\"type\":\"Medium-end\",\"os\":\"Windows\"},{\"name\":\"HP Probook\",\"description\":\"probook\",\"price\":\"3000$\",\"type\":\"high-end\",\"os\":\"ubuntu\"},{\"name\":\"HP pavillion\",\"description\":\"string\",\"price\":\"4000$\",\"type\":\"high-end\",\"os\":\"ubuntu\"}]", new TypeReference<List<Product>>() {});
            //Filtering Products and returning products
            final List<Product> windowsProducts = productList.stream().filter(product -> "Windows".equals(product.getOs())).collect(Collectors.toList());
            //Processing products and returning a map of name & price
            final Map<String, String> collect = productList.stream().collect(Collectors.toMap(x -> x.getName(), x -> x.getPrice()));
            //Extract Map out of collection of Objects
            final Map<String, String> collect1 = productList.stream().filter(p -> "Windows".equals(p.getOs())).collect(Collectors.toMap(x -> x.getName(), x -> x.getPrice()));
            System.out.println("Initial Map size:  "+collect.size());

            List<Product> collect2 = productList.stream().sorted((x,y)->x.getPrice().compareTo(y.getPrice())).collect(Collectors.toList());
            System.out.println("sorted products "+collect2);

            System.out.println("Filtered Map size: "+collect1.size());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
