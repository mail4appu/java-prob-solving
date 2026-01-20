package com.checkpoint.springredis.rest.impl;

import com.checkpoint.springredis.dao.ProductRepositoryV1;
import com.checkpoint.springredis.model.Product;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


@RequestMapping("/v1")
@RestController
public class ProductResourceV1 {

    Logger logger = LoggerFactory.getLogger(ProductResourceV1.class);

    @Autowired
    ProductRepositoryV1 productRepositoryV1;


    @RequestMapping(value = "/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProduct(@RequestBody Product product) {
        productRepositoryV1.save(product);
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(value = "/products", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProductsInBulk(@RequestParam MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootArray = null;
        Set<Product> productSet = new HashSet<>();
        try {
            rootArray = objectMapper.readTree(file.getInputStream());
            for (JsonNode node : rootArray) {
                Product product = objectMapper.treeToValue(node, Product.class);
                productSet.add(product);

            }
        } catch (IOException e) {
            logger.error("Exception occurred while adding products in bulk", e);
        }
        productSet.parallelStream().forEach(product -> productRepositoryV1.save(product));
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> getAllProducts(@RequestParam(value = "price_range", required = false) String priceRange) {
        if (StringUtils.isNotBlank(priceRange)) {
            return productRepositoryV1.findProductsByPriceRange(priceRange);
        }
        return productRepositoryV1.findAll();

    }

}
