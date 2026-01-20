package com.checkpoint.springredis.rest.impl;

import com.checkpoint.springredis.dao.ProductRepositoryImplV2;
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

@RestController
@RequestMapping("/v2")
public class ProductResourceV2 {

    Logger logger = LoggerFactory.getLogger(ProductResourceV2.class);

    @Autowired
    ProductRepositoryImplV2 productRepositoryImplV2;


    @RequestMapping(value = "/set/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProduct(@RequestBody Product product) {
        productRepositoryImplV2.saveInSet(product);
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(value = "/set/products", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProductsInBulk(@RequestParam MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootArray = objectMapper.readTree(file.getInputStream());
            productRepositoryImplV2.saveAllInSet(rootArray);
        } catch (IOException e) {
            logger.error("Exception occurred while reading file ", e);
        }
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(value = "/set/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> getAllProducts() {
        return productRepositoryImplV2.findAllProductsFromSet();

    }



    @RequestMapping(value = "/map/products", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProductInMap(@RequestBody Product product) {
        productRepositoryImplV2.saveInMap(product);
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(value = "/map/products", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addProductsInMapInBulk(@RequestParam MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode rootArray = objectMapper.readTree(file.getInputStream());
            productRepositoryImplV2.saveAllInMap(rootArray);
        } catch (IOException e) {
            logger.error("Exception occurred while reading file ", e);
        }
        return new ResponseEntity(HttpStatus.CREATED);

    }


    @RequestMapping(value = "/map/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> getAllProductsFromMap(@RequestParam(value = "price_range", required = false) String priceRange, @RequestParam(value = "brand", required = false) String brand, @RequestParam(value = "offSet", required = false, defaultValue = "0") int offSet, @RequestParam(value = "limit", required = false, defaultValue = "0") int limit) {
        if (StringUtils.isNotBlank(priceRange)) {
            return productRepositoryImplV2.filterProductsByPriceRange(priceRange, limit, offSet);
        }
        else if(StringUtils.isNotBlank(brand)) {
            return productRepositoryImplV2.filterProductsByBrand(brand, limit, offSet);
        }
        return productRepositoryImplV2.findAllProductsFromMap();

    }



}
