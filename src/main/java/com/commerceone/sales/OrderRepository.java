package com.commerceone.sales;

import com.commerceone.shared.repository.BaseRepository;

public class OrderRepository extends BaseRepository<Order, Long> {

	public OrderRepository() {
		super(Order.class);
	}

	
	
}
