package com.commerceone.sales;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private static Logger logger = Logger.getLogger(OrderService.class);  
	
	@Autowired
	private OrderRepository repository;
	
	public OrderService() {	
		
		logger.debug( ".... Created OrderService and repository is " +  repository );
		
	}
	
	@PostConstruct
	public void init() {
		logger.debug( ".... OrderService Initialized and repository is " +  repository );		
	}
	
}
