package com.checkpont.shoppingcart;

public interface ICheckout {
    public void scan(String item);
    public double calculateMyOrderTotal();
}
