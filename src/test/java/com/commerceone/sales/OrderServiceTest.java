package com.commerceone.sales;

import java.util.Date;
import java.util.List;

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
		order.setCustomer(new Customer( 1L));

		order.setSupplier(new Supplier("Supplier XPTO"));

		order.setCreatedDate(new Date());
		order.add("PRD XYZ");
		
		service.createSalesOrder(order);
		
		List<OrderItem> items = order.getItems();
		OrderItem item = items.get(0);
		
	}
	
	
}
