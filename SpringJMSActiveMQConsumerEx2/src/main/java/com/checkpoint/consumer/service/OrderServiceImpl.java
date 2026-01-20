package com.checkpoint.consumer.service;

import com.checkpoint.consumer.model.InventoryResponse;
import com.checkpoint.consumer.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);

	
	@Override
	public void processOrder(Product product) {
		
		InventoryResponse response = prepareResponse(product);
		LOG.info("Inventory : sending order confirmation {}", response);
		//messageSender.sendMessage(response);
	}
	
	private InventoryResponse prepareResponse(Product product){
		InventoryResponse response = new InventoryResponse();
		response.setProductId(product.getProductId());
		response.setReturnCode(200);
		response.setComment("Order Processed successfully");
		return response;
	}

	
	
}
