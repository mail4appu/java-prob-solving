package com.schneider.batch.resource;

import com.schneider.batch.dao.ProductDao;
import com.schneider.batch.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by SESA439295 on 6/13/2017.
 */
@Component
@Path("/")
public class ProductResourceImpl implements ProductResource {

    @Autowired
    ProductDao productDao;


    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response getProducts() {
        List<Product> productList = productDao.getList();
        return Response.ok(productList).build();

    }

    @POST
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response createProduct(Product product) throws Exception {
        //Get list from DB and compare against request
        for (Product productFromDB : productDao.getList()) {
            if (product.getId() == productFromDB.getId()) {
                //TODO Need proper exception handling
                throw new Exception("product with Id "+product.getId()+" already exits :");
            }
        }
        Product productInResp = productDao.addProduct(product);
        return Response.ok(productInResp).build();
    }

    @PUT
    @Path("/product/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response updateProduct(Product product) {
        return Response.ok(product).build();
    }

   /* @DELETE
    @Path("/product")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Override
    public Response deleteProduct() {
        return Response.ok().build();
    }*/
}
