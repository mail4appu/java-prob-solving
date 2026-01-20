package com.checkpont.shoppingcart.impl;

import com.checkpont.shoppingcart.ApplicationCache;
import com.checkpont.shoppingcart.ICartService;
import com.checkpont.shoppingcart.ThreadSafeCart;
import com.checkpont.shoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class CartServiceImpl implements ICartService {
    @Autowired
    ApplicationCache applicationCache;


    @Override
    public void addToCart(String item) {
        Product product = applicationCache.getProductsCache().get(item);
        Map<String, Integer> checkoutMap = ThreadSafeCart.checkoutMap.get();
        if (product != null) { //valid product

            Integer itemQuantity = checkoutMap.get(item);
            if (itemQuantity==null) {
                checkoutMap.put(item, 1);
            } else {
                checkoutMap.put(item, itemQuantity + 1);
            }
        } else{  // In valid product. Dont add this item  to cart

        }

    }





}
