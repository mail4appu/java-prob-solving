package com.idrive.server.resources;

import com.idrive.bean.Stock;
import com.idrive.bean.StockHolder;
import com.idrive.util.Validator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by SESA439295 on 1/11/2018.
 */
@Component // this is very much required to inject spring beans into jersey resources
@Path("/stock")
public class StockService {

    private static final Logger log= Logger.getLogger(Myservice.class);


    @GET
    @Path("/price")
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
