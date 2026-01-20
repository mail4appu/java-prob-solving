package com.checkpont.shoppingcart.impl;

import com.checkpont.shoppingcart.IPricingStrategy;
import com.checkpont.shoppingcart.model.Product;

public class UnitPricingPolicyImpl implements IPricingStrategy {
    @Override
    public double applyPrice(Product product, int quantity) {
        return (product.getUnitPrice())*quantity;


    }
}
