package com.checkpont.shoppingcart.impl;

import com.checkpont.shoppingcart.IPricingStrategy;
import com.checkpont.shoppingcart.model.Product;

public class OfferPricePolicyImpl implements IPricingStrategy {
    @Override
    public double applyPrice(Product product, int quantity) {
        int offerQuantity = product.getOfferQuantity();

        int offerAppliedTimes = 0;
        if (offerQuantity != 0)
            // offer to be applied  for "offerAppliedTimes" times
            offerAppliedTimes = quantity / offerQuantity;
        return offerAppliedTimes * (product.getOfferPrice());

    }
}
