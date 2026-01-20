package com.checkpont.shoppingcart.impl;

import com.checkpont.shoppingcart.ICartService;
import com.checkpont.shoppingcart.ICheckout;
import com.checkpont.shoppingcart.IPricingService;
import com.checkpont.shoppingcart.ThreadSafeCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CheckoutImpl implements ICheckout {

   @Autowired
   ICartService iCartService;

    @Autowired
    IPricingService pricingService;

    @Override
    public void scan(String item) {
        iCartService.addToCart(item);

    }

    @Override
    public double calculateMyOrderTotal() {
        System.out.println("Calculating total price of checkout ");
        Map<String, Integer> checkoutMap = ThreadSafeCart.checkoutMap.get();
        if(!checkoutMap.isEmpty()) {
            double totalPrice= pricingService.getTotalPrice(checkoutMap);
            System.out.println("Total check out price"+totalPrice);
            return totalPrice;
        }

        return 0;
    }
}
