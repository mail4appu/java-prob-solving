package com.checkpoint.swaggerdemo.rest;

import com.checkpoint.swaggerdemo.model.Product;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
public interface ProductResource {



    List<?> getAllProducts(List<String> types, String os, String offset, String limit, String version);

    String addProduct(Product product);

    Optional<Product> getSingleProduct(String productId);

    Product updateProduct(String productId, Product product);

    void deleteProduct(String productId);

}
