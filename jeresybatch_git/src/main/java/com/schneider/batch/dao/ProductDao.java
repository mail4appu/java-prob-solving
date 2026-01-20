package com.schneider.batch.dao;

import com.schneider.batch.model.Product;

import java.util.List;

/**
 * Created by SESA439295 on 6/21/2017.
 */
public interface ProductDao {
    List<Product> getList();
    Product addProduct(Product product) throws Exception;

}
