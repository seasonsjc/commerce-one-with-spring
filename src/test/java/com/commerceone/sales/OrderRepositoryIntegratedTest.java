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
		customer.setId(1L);
		customer.setName("CUSTOMER NAME2");
		
		Supplier supplier = new Supplier();
		supplier.setId(1L);
		supplier.setName("SUPPLIER NAME2");
		
		Order order = new Order ();
		
		order.setCustomer(customer);
		order.setCreatedDate(new Date());
		order.setSupplier(supplier);
		
		repository.create(order);
		
		
	}
	
	

}
