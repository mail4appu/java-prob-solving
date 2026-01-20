package com.checkpont.shoppingcart;

import com.checkpont.shoppingcart.model.Product;

public interface IPricingStrategy {
    double applyPrice(Product product, int quantity);
}
