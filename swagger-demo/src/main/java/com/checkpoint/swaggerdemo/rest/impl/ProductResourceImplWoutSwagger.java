/*
package com.checkpoint.swaggerdemo.rest.impl;

import com.checkpoint.swaggerdemo.dao.ProductRepository;
import com.checkpoint.swaggerdemo.model.Product;
import com.checkpoint.swaggerdemo.rest.ProductResource;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.SafeHtml;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/products")
public class ProductResourceImplWoutSwagger implements ProductResource {

    private Logger logger = LoggerFactory.getLogger(ProductResourceImplWoutSwagger.class);

    @Autowired
    ProductRepository productRepository;


    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Product> getAllProducts(
           @RequestParam(name = "type", required = false) List<String> types,
           @Length @SafeHtml @DefaultValue(value = "windows") @RequestParam(name="os", required = false) String os) {
        logger.debug("Product types received from request {} ", types);
        return productRepository.findAll();

    }


    @RequestMapping(consumes = "application/json", method = RequestMethod.POST, produces = "application/json")
    public String addProduct(@Valid @RequestBody Product product){
        logger.debug("Creating product");
        String productId=productRepository.save(product).getId();
        logger.info("Successfully created product with id {}", productId);
        return productId;
    }


    @RequestMapping(method = RequestMethod.GET, value="/{productId}", produces = "application/json")
    public Optional<Product> getSingleProduct(@PathVariable String productId) {
        logger.debug("Fetch product from Database using product id {} ", productId);
        return productRepository.findById(productId);

    }

    @RequestMapping(method = RequestMethod.PUT, value="/{productId}", consumes = "application/sjon", produces = "application/json")
    public Product updateProduct(@PathVariable(name = "productId" ) String productId, @RequestBody Product product) {
        logger.debug("Updating the product {} with product {}", productId, product);
        product.setId(productId);
        return productRepository.save(product);

    }


    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String productId) {
        logger.debug("Deleting product with product Id {} ", productId);
        productRepository.deleteById(productId);
        logger.info("Deleted product with id {} ", productId);

    }

}
*/
