package com.checkpont.shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ThreadSafeCart {
    public static ThreadLocal<Map<String,Integer>> checkoutMap = new ThreadLocal<Map<String, Integer>>(){
        @Override
        protected Map<String, Integer> initialValue() {
            return new HashMap<>();
        }

        @Override
        public Map<String, Integer> get() {
            return super.get();
        }
    };
}
