package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepositoryV1 extends CrudRepository<Product, String> {
    List<Product> findProductsByPriceRange(String priceRange);
    Product findProductById(String id);
}