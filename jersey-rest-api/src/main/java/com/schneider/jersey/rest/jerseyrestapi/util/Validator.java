package com.schneider.jersey.rest.jerseyrestapi.util;

import com.schneider.jersey.rest.jerseyrestapi.bean.StockHolder;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by SESA439295 on 1/10/2018.
 */
public class Validator {

    public void validate(StockHolder stockHolder) throws Exception {
        System.out.println("inside validator");
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();
        Set<ConstraintViolation<StockHolder>> violations= validator.validate(stockHolder);
        for (ConstraintViolation<StockHolder> violation : violations) {
            System.out.println("Violation errors include:    "+violation.getMessage()+"###############: "+violation.getPropertyPath()+"$$$$$$$$$$$$:  "+violation.getLeafBean());
            throw new Exception("validation errors exist");
        }

    }
}
