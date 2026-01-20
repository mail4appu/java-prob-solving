package com.checkpoint.swaggerdemo.rest.impl;


import com.checkpoint.swaggerdemo.constants.ProductConstants;
import com.checkpoint.swaggerdemo.dao.ProductRepository;
import com.checkpoint.swaggerdemo.error.CheckpointError;
import com.checkpoint.swaggerdemo.model.Product;
import com.checkpoint.swaggerdemo.model.ProductV2;
import io.swagger.annotations.*;
import io.swagger.models.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@SwaggerDefinition(tags = {
        @Tag(name = "Administration", description = "Administration context for use by administrators"),
        @Tag(name = "Runtime", description = "Runtime context for use by end users"),
        @Tag(name = "Operations", description = "Operations context for operations & monitoring")})

@RestController
@RequestMapping(value = "/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Validated // This is for enabling javax validations on query & path params. This is from spring
public class ProductResourceImpl  {


    private Logger logger = LoggerFactory.getLogger(ProductResourceImpl.class);

    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value = "Returns all the products from the system", notes = " This api can be used without authentication", tags = {"Read-Operations"})
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<?> getAllProducts(
            @ApiParam(name = "type", value="Type of the product", allowableValues="high-end, medium-end, low-end", allowMultiple = true) @DefaultValue(value = "high-end") @RequestParam(name = "type", required = false) List<String> types,
            @ApiParam(name="os", value="Operating System", allowableValues = "windows, linux, ios", defaultValue = "windows") @DefaultValue(value = "windows") @RequestParam(name="os", required = false) String os,
            @ApiParam(name="offset", value="offset value")  @RequestParam(name="pageNumber", required = false, defaultValue = "0") String pageNumber,
            @ApiParam(name="limit", value="limit value")   @Pattern(regexp = ProductConstants.LIMIT_REGEX, message = "Limit can not be negative") @RequestParam(name="limit", required = false, defaultValue = "10") String limit,
            @ApiParam(name="version", value="version Value")  @Pattern(regexp = ProductConstants.VERSION_REGEX, message = "Version must be a integer between 1 to 9") @RequestParam(name="version", required = false) String version,
            @ApiParam(name="isLatest", value="latest Api response")   @RequestParam(name="isLatest", required = false) boolean isLatest) {
        if(!StringUtils.isEmpty(version)){
            return getVersionedProduct(version);
        }
        logger.debug("isLatest from request {} ", isLatest);
        logger.debug("Product types received from request {} ", types);
        Pageable pageable= PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(limit));
        return productRepository.findAll(pageable).get().collect(Collectors.toList());

    }

    private List<ProductV2>     getVersionedProduct(String version) {
        List<ProductV2> productV2s = new ArrayList<>();
        ProductV2 productV2=new ProductV2();
        productV2.setType(1000);
        productV2s.add(productV2);
        return productV2s;

    }


    @ApiOperation(value = "This api is used to add products into the system", notes = "This api needs authentication", tags = {"Write-Operations"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @ApiResponses(value={@ApiResponse(code = 500, message = "Internal Server Error"),
                         @ApiResponse(code = 400, message = "Bad Request", response = CheckpointError.class),
                         @ApiResponse(code = 401, message = "Un-Authorized", response = CheckpointError.class),
                         @ApiResponse(code = 200, message = "Created"),
                         @ApiResponse(code = 201, message = "Successfully Accepted")

    })
    @RequestMapping(value = "", consumes = "application/json", method = RequestMethod.POST,  produces = "application/json")
    public ResponseEntity addProduct(@Valid @ApiParam(required = true)  @RequestBody  Product product){
        logger.debug("Creating product");
        String productId=productRepository.save(product).getId();
        logger.info("Successfully created product with id {}", productId);

        final URI location = ServletUriComponentsBuilder
                .fromCurrentServletMapping().path("/products/{id}").build()
                .expand(productId).toUri();

        final HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);

        return  new ResponseEntity<Void>(HttpStatus.CREATED);

    }

    @Deprecated
    @ApiOperation(value = "This api is used to add products into the system", notes = "This api needs authentication", tags = {"Write-Operations"})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @ApiResponses(value={@ApiResponse(code = 500, message = "Internal Server Error", response = CheckpointError.class),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Un-Authorized"),
            @ApiResponse(code = 201, message = "Successfully Created", response = Product.class)})
    @RequestMapping(value = "/v0", consumes = "application/json", method = RequestMethod.POST, produces = MediaType.ALL_VALUE)
    public String addProductV0(@Valid @ApiParam(required = true)  @RequestBody  Product product){
        logger.debug("Creating product");
        String productId=productRepository.save(product).getId();
        logger.info("Successfully created product with id {}", productId);
        return productId;

    }


    @ApiOperation(value = "Returns a single product from the system", notes = " This api can be used without authentication", tags = {"Read-Operations"}, response = Product.class)
    @ApiResponses({@ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, value="/{productId}", produces = "application/json")
    public Optional<Product> getSingleProduct(@PathVariable String productId) {
        logger.debug("Fetch product from Database using product id {} ", productId);
        return productRepository.findById(productId);

    }

    @ApiOperation(value = "Returns a single product from the system", notes = " This api can be used without authentication", tags = {"Read-Operations"}, response = Product.class)
    @ApiResponses({@ApiResponse(code = 500, message = "Internal Server Error")})
    @RequestMapping(method = RequestMethod.GET, value="/{productId}/test", produces = "application/json")
    public @ResponseBody DeferredResult<String> getSingleProductWithDeferredResult(@PathVariable String productId, @RequestParam("defResult") boolean defResult) {
        logger.debug("Fetch product from Database using product id {} -- Deferred Result check", productId);

        logger.info("handler started");
        final DeferredResult<String> deferredResult = new DeferredResult<>();

        new Thread(() -> {
            logger.info("async task started");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("async task finished");
            deferredResult.setResult("test async result");
        }).start();

        logger.info("handler finished");
        return deferredResult;

    }




    //No swagger annotations defined for the api parameters
    @ApiOperation(value = "Updates a single product in the system", notes = " This api require authentication", tags = {"Write-Operations"}, response = Product.class)
    @ApiResponses(value={@ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Un-Authorized"),
            @ApiResponse(code = 201, message = "Successfully Created")})
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token", required = true, dataType = "string", paramType = "header")})
    @RequestMapping(method = RequestMethod.PUT, value="/{productId}",consumes = "application/json", produces = "application/json")
    public Product updateProduct(@PathVariable(name = "productId" ) String productId, @RequestBody Product product) {
        logger.debug("Updating the product {} with product {}", productId, product);
        product.setId(productId);
        return productRepository.save(product);

    }


    @ApiResponses({@ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Internal Server Error")})
    @ApiOperation(value = "Delete a product by its id", notes = "Deletes single given product", tags = {"Write-Operations"})
    @RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
    public void deleteProduct(@ApiParam(name = "productId", value="Id of the product under deletion") @PathVariable String productId) {
        logger.debug("Deleting product with product Id {} ", productId);
        productRepository.deleteById(productId);
        logger.info("Deleted product with id {} ", productId);

    }
}
