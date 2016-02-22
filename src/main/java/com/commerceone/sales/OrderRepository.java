package com.commerceone.sales;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.commerceone.shared.repository.BaseRepository;

@Repository
@Scope(value="prototype")
public class OrderRepository
	extends BaseRepository<Order, Long> {
	
	private Logger logger = Logger.getLogger(OrderRepository.class);
	
	public OrderRepository() {
		super(Order.class);
		logger.debug(".............. OrderRepository Created");
	}

	
	
}
