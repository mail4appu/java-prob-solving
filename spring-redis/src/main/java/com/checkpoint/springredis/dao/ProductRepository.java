package com.checkpoint.springredis.dao;

import com.checkpoint.springredis.model.ProductCustomizations;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
@Repository
public interface ProductRepository {
    public Map<String, JsonNode> findAll();

    public Collection<JsonNode> findAllProducts();

    public JsonNode getSingleProduct(String id);

    //public void saveProduct(JsonNode jsonRootNode);

    void saveProductsInSet(JsonNode rootArray);

    void saveProductsInMap(JsonNode rootArray);

    //Collection<JsonNode> findAllProducts(ProductCustomizations productCustomizations);

    Collection<JsonNode> findAllProductsFromMap(ProductCustomizations productCustomizations);

    Collection<JsonNode> findAllProductsFromSet(ProductCustomizations productCustomizations);

    Collection<JsonNode> findAllProductsFromSetWithTemplate(ProductCustomizations productCustomizations);
}
