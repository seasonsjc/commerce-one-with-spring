package com.commerceone.sales;

import java.util.Date;

import com.commerceone.account.Supplier;

import com.commerceone.account.Customer;

import org.junit.Test;

public class OrderRepositoryIntegratedTest {
	
	
	@Test
	public void createOrder() {
		
		OrderRepository repository = new OrderRepository();
		
		Customer customer = new Customer();
		customer.setName("CUSTOMER NAME");
		
		Supplier supplier = new Supplier();
		supplier.setName("SUPPLIER NAME");
		
		Order order = new Order ();
		
		order.setCustomer(customer);
		order.setCreatedDate(new Date());
		order.setSupplier(supplier);
		
		repository.create(order);
		
		
	}
	
	

}
