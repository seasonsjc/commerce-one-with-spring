package com.commerceone.sales;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.commerceone.account.Customer;
import com.commerceone.account.Supplier;

public class OrderFixtureFactory {
	
	
	public static List<Order> newOrders () {
		List<Order> orders = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			orders.add( newOrder ("ORD-" +  (i+1)) );
		}
		
		return orders;
	}
	
	public static Order newOrder(String value) {
		
		Order order = new Order();
		order.setCustomer(new Customer( 1L ));
		order.setSupplier(new Supplier("Supplier XPTO" + value));
		order.setCreatedDate(new Date());
		order.add("PRD XYZ" + value);

		return order;
	}

}
