package com.commerceone.sales;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.commerceone.account.Customer;
import com.commerceone.account.Supplier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application-context.xml")
public class OrderServiceTest {
	
	@Autowired
	private OrderService service;
	
	@Test
	public void testA () {
		
		Order order = new Order();
		order.setCustomer(new Customer("XPTO"));

		order.setSupplier(new Supplier("Supplier XPTO"));

		order.setCreatedDate(new Date());
		
		service.createSalesOrder(order);
		
	}
	
	
}
