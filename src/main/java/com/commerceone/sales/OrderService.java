package com.commerceone.sales;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.billing.BillingService;
import com.commerceone.integrator.IntegratorService;
import com.commerceone.notification.NotificationRepository;
import com.commerceone.notification.NotificationService;

@Service
public class OrderService {

	private static Logger logger = Logger.getLogger(OrderService.class);  
	
	@Autowired
	private BillingService billingService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private IntegratorService integratorService;
	
	
	@Autowired
	private OrderRepository repository;
	
	public OrderService() {			
		logger.debug( ".... Created OrderService and repository is " +  repository );
	}
	
	
	@Transactional
	public void createSalesOrder (Order order) {
		
		repository.create(order);
		billingService.startBillingFor(order);
		notificationService.sendMailToSupplier(order);
		notificationService.sendMailToCustomer(order);
		integratorService.sendToSupplier(order);
		integratorService.sendToCustomer(order);
			
	}
	
	
	@PostConstruct
	public void init() {
		logger.debug( ".... OrderService Initialized and repository is " +  repository );		
	}
	
}
