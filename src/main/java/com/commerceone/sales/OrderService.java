package com.commerceone.sales;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.Specifications.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.billing.BillingService;
import com.commerceone.event.EventLog;
import com.commerceone.event.EventRepository;
import com.commerceone.integrator.IntegratorService;
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
	private EventRepository eventRepository;
	
	@Autowired
	private OrderRepository repository;
	
	public OrderService() {			
		logger.debug( ".... Created OrderService and repository is " +  repository );
	}
	
	
	@Transactional
	public void createSalesOrder (Order order) {
		
		EventLog event = new EventLog();
		event.setName("CreateSalesORder");
		try {
			
			repository.save(order);

			billingService.startBillingFor(order);
			
			notificationService.sendMailToSupplier(order);
			notificationService.sendMailToCustomer(order);
			
			integratorService.sendToSupplier(order);
			integratorService.sendToCustomer(order);
		
			event.setStatus("Success");
			
		} catch (Exception e) {
			event.setStatus("Error" + e );
			throw e;
		} finally {
			eventRepository.create(event);
		}
		
			
	}
	
	
	
	
	@PostConstruct
	public void init() {
		logger.debug( ".... OrderService Initialized and repository is " +  repository );		
	}
	
	public OrderRepository getAll() {
		return repository;
	}
	
	public List<Order> search (OrderCriteria criteria) {
		
		OrderSpecifications specs = new OrderSpecifications(criteria);
		
		return repository.findAll(  where(  specs.withOrderNumber())
								.and(specs.withStartDate())
								.and(specs.withEndDate())
									 );
		
	}
	
	
}
