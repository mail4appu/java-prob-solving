package com.schneider.jersey.rest.jerseyrest.resource;

import com.schneider.jersey.rest.jerseyrest.bean.StockHolder;
import com.schneider.jersey.rest.jerseyrest.util.Validator;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by SESA439295 on 1/11/2018.
 */
@Component // this is very much required to inject spring beans into jersey resources
@Path("/stock")
public class StockResource {



    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStockPrice(@QueryParam("status") @DefaultValue("0") String status) {
        System.out.println(Integer.parseInt(status));
        return Response.ok().entity("service is up").build();
    }

    @POST
    @Path("/register")
    @Consumes({MediaType.APPLICATION_JSON })
    @Produces({ MediaType.TEXT_HTML })
    public String registerStockHolder(StockHolder stockHolder ) throws Exception {
        Validator validator= new Validator();
        validator.validate(stockHolder);
        stockHolder.getStocks().get(0).getStockPrice();
        return "Successfully added the stockholder";


    }
}
