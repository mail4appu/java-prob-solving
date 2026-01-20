package com.checkpoint.springredis.rest.impl;

import com.checkpoint.springredis.dao.ProductRepository;
import com.checkpoint.springredis.model.ProductCustomizations;
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
import java.util.Collection;

@RestController
@RequestMapping("/")
public class ProductsResource {
    private Logger logger = LoggerFactory.getLogger(ProductsResource.class);

    @Autowired
    ProductCustomizations productCustomizations;


    @Autowired
    ProductRepository productRepository;

    @RequestMapping(value = "/map/products", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity addProductsInBulk(@RequestParam MultipartFile file) {
        logger.debug("Before inserting mass data into redis");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootArray = null;
        try {
            rootArray = objectMapper.readTree(file.getInputStream());
            logger.debug("Original input stream " + rootArray.toPrettyString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        productRepository.saveProductsInMap(rootArray);
        logger.debug("Successfully uploaded mass data into redis");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "/set/products", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity addProductsInBulkInSet(@RequestParam MultipartFile file) {
        logger.debug("Before inserting mass data into redis");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootArray = null;
        try {
            rootArray = objectMapper.readTree(file.getInputStream());
            logger.debug("Original input stream " + rootArray.toPrettyString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        productRepository.saveProductsInSet(rootArray);
        logger.debug("Successfully uploaded mass data into redis");
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }


  /*  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<JsonNode> getAllProducts() {
        return productRepository.findAllProducts();

    }*/


    @RequestMapping(value = "/set/products",method = RequestMethod.GET, produces = "application/json")
    public Collection<JsonNode> getPaginatedProductsFromSet(@RequestParam(value = "priceRange", required = false) String priceRange) {
        if(StringUtils.isNotBlank(priceRange)) {
            productCustomizations.setPriceRange(priceRange);
        }
        return productRepository.findAllProductsFromSetWithTemplate(productCustomizations);

    }

    @RequestMapping(value = "/map/products",method = RequestMethod.GET, produces = "application/json")
    public Collection<JsonNode> getPaginatedProductsFromMap(@RequestParam(value = "priceRange", required = false) String priceRange) {
        if(StringUtils.isNotBlank(priceRange)) {
            productCustomizations.setPriceRange(priceRange);
        }
        return productRepository.findAllProductsFromSet(productCustomizations);

    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public JsonNode getSingleProduct(@PathVariable(value = "id") String productId) {
        return productRepository.getSingleProduct(productId);

    }


}
