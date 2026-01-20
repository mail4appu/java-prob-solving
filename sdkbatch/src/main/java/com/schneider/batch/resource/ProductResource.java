package com.schneider.batch.resource;

import com.schneider.batch.model.Product;

import javax.ws.rs.core.Response;

/**
 * Created by SESA439295 on 6/13/2017.
 */
public interface ProductResource {

    public Response getProducts();

    public Response createProduct(Product prodcut, String authorization) throws Exception;

    public Response updateProduct(Product product);

    //public Response deleteProduct();

}
