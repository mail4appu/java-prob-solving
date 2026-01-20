package com.checkpont.shoppingcart.factory;

import com.checkpont.shoppingcart.IPricingStrategy;
import com.checkpont.shoppingcart.impl.OfferPricePolicyImpl;
import com.checkpont.shoppingcart.impl.UnitPricingPolicyImpl;
import com.checkpont.shoppingcart.model.Product;

import java.util.HashMap;
import java.util.Map;

public class PriceFactory {

   static  Map<String, IPricingStrategy> strategy= new HashMap<>();


    public static IPricingStrategy getPriceStrategy(Product product, int quantityToBeConsidered){ //get objects prepared  as evolved
        if(quantityToBeConsidered!=0 && product.getOfferQuantity()!=0 && quantityToBeConsidered>=product.getOfferQuantity()){
            return  new OfferPricePolicyImpl();
        }else{
           return  new UnitPricingPolicyImpl();
        }

    }

}
