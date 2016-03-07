package com.commerceone.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class CreateSalesOrderController {

	@Autowired
	private OrderService service;
	
	@RequestMapping (method=RequestMethod.POST , value="/add" ) 
	public Order add ( @RequestBody Order order) {
		service.createSalesOrder(order);
		return order;
	}
	
	@RequestMapping (method=RequestMethod.GET , value="/all") 	
	public List<Order> all() {
		return service.getAll().findAll();
	}
	
	
	
}
