package com.checkpont.shoppingcart;

import java.util.Map;

public interface IPricingService {
    double getTotalPrice(Map<String, Integer> checkoutMap);
}
