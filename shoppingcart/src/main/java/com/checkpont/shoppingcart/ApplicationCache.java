package com.checkpont.shoppingcart;

import com.checkpont.shoppingcart.model.Product;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ApplicationCache {
    Map<String, Product> productsCache = new HashMap<>();

    public Map<String, Product> getProductsCache() {
        return productsCache;
    }


    @PostConstruct
    public void prepareCache() throws Exception {
        List<Product> productList = null;
        try {
            ClassLoader classLoader = ShoppingCartApplication.class.getClassLoader();
            File configFile = new File(classLoader.getResource("products.json").getFile());
            FileInputStream inputStream = new FileInputStream(configFile);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            ObjectMapper objectMapper = new ObjectMapper();
            Product[] products = objectMapper.readValue(reader, Product[].class);
            productList = Arrays.asList(products);
            productList.stream().forEach(product -> {
                productsCache.put(product.getId(), product);
            });
            System.out.println("Products in cache: " + productsCache.size());

        } catch (JsonMappingException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
