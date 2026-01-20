package com.checkpont.shoppingcart.impl;

import com.checkpont.shoppingcart.IPricingService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class PricingServiceImplTest {

    @Autowired
    IPricingService pricingService;

    @Test
    public void testTotalPriceWithAllValidProducts(){
        Map<String, Integer> checkoutMap= new HashMap<>();
        checkoutMap.put("A", 5);
        checkoutMap.put("B", 1);
        checkoutMap.put("C", 7);
        double totalPrice = pricingService.getTotalPrice(checkoutMap);
        Assert.assertEquals(380, totalPrice, 0);

    }

    @Test
    public void testTotalPrice_UnSupported_Products(){
        Map<String, Integer> checkoutMap= new HashMap<>();
        checkoutMap.put("E", 5);
        checkoutMap.put("F", 1);
        checkoutMap.put("G", 7);
        double totalPrice = pricingService.getTotalPrice(checkoutMap);
        Assert.assertEquals(0, totalPrice, 0);

    }


    @Test
    public void testTotalPrice_Partially_UnSupported_Products(){
        Map<String, Integer> checkoutMap= new HashMap<>();
        checkoutMap.put("A", 5);
        checkoutMap.put("F", 1);
        checkoutMap.put("C", 7);
        checkoutMap.put("D", 7);
        checkoutMap.put("F", 7);
        double totalPrice = pricingService.getTotalPrice(checkoutMap);
        Assert.assertEquals(455, totalPrice, 0);

    }


    @Test
    public void testTotalPrice_When_Cart_Emtpy(){
        Map<String, Integer> checkoutMap= new HashMap<>();
        double totalPrice = pricingService.getTotalPrice(checkoutMap);
        Assert.assertEquals(0, totalPrice, 0);

    }


}