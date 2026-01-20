package com.checkpont.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShoppingCartApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext run = SpringApplication.run(ShoppingCartApplication.class, args);
		ICheckout checkout = (ICheckout)run.getBean("checkoutImpl");
		checkout.scan("A");
		checkout.scan("B");
		checkout.scan("C");
		checkout.scan("A");
		checkout.scan("A");
		checkout.scan("B");
		checkout.scan("B");
		checkout.scan("D");
		checkout.scan("D");
		checkout.calculateMyOrderTotal();


	}


}
