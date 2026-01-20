package com.checkpont.shoppingcart.impl;

import com.checkpont.shoppingcart.ICheckout;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CheckoutImplTest {

    @Autowired
    ICheckout checkout;


    /**
     * This is to verify every thread gets different checkout cart i.e Map
     *  Not so elegant verification but gives us some control
     */
    @Test
    public void calculateOrderTotalByDifferentThread(){
        new Thread(()-> {
            for (int i = 0; i < 5; i++)
                checkout.scan("A");
        }).start();

        Assert.assertEquals(0, checkout.calculateMyOrderTotal(), 0);


    }


    @Test
    public void calculateOrderTotalByMainThread() {
        for (int i = 0; i < 5; i++){
            checkout.scan("A");
          }
        Assert.assertEquals(230, checkout.calculateMyOrderTotal(), 0);


    }



}