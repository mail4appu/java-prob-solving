package com.checkpont.shoppingcart.impl;

import com.checkpont.shoppingcart.ApplicationCache;
import com.checkpont.shoppingcart.IPricingService;
import com.checkpont.shoppingcart.IPricingStrategy;
import com.checkpont.shoppingcart.factory.PriceFactory;
import com.checkpont.shoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class PricingServiceImpl implements IPricingService {

    IPricingStrategy iPricingStrategy;

    @Autowired
    ApplicationCache applicationCache;


    @Override
    public double getTotalPrice(Map<String, Integer> checkoutMap) {
        Map<String, Product> productsCache = applicationCache.getProductsCache();
        Set<String> itemIds = checkoutMap.keySet();
        AtomicReference<Double> totalPrice = new AtomicReference<>((double) 0);
        itemIds.stream().forEach(itemId -> {
            Product product = productsCache.get(itemId);
            if(Objects.nonNull(product)) {
                int offerQuantity = product.getOfferQuantity();
                Integer quantityDuringCheckout = checkoutMap.get(itemId);
                int unitPriceAppliedCount = quantityDuringCheckout;
                int offerPriceAppliedCount = 0;
                if (offerQuantity != 0) {
                    unitPriceAppliedCount = quantityDuringCheckout % offerQuantity;
                    offerPriceAppliedCount = quantityDuringCheckout - unitPriceAppliedCount;
                }
                calculateTotalPrice(totalPrice, product, unitPriceAppliedCount, offerPriceAppliedCount);
            }

        });


        return totalPrice.get();
    }

    private void calculateTotalPrice(AtomicReference<Double> totalPrice, Product product, int unitPriceAppliedCount, int offerPriceAppliedCount) {

        //Apply offer price
        iPricingStrategy = PriceFactory.getPriceStrategy(product, offerPriceAppliedCount);
        double itemPriceWithOffer = iPricingStrategy.applyPrice(product, offerPriceAppliedCount);

        //Apply unit price
        iPricingStrategy = PriceFactory.getPriceStrategy(product, unitPriceAppliedCount);
        double itemPriceWithoutOffer = iPricingStrategy.applyPrice(product, unitPriceAppliedCount);

        //get total price
        totalPrice.updateAndGet(v -> new Double((double) (v + itemPriceWithOffer + itemPriceWithoutOffer)));
    }
}
