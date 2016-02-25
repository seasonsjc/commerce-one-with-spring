package com.commerceone.integrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.event.Queue;
import com.commerceone.event.QueueRepository;
import com.commerceone.sales.Order;

@Service
public class IntegratorService {

	@Autowired
	private QueueRepository repository;
	
	@Transactional
	public void sendToSupplier (Order order) {
		
		Queue queue = new Queue();
		queue.setName("CREATE_SALES_ORDER");
		repository.create(queue);
				
	}

	@Transactional
	public void sendToCustomer (Order order) {
		
		Queue queue = new Queue();
		queue.setName("CREATE_PURCHASE_ORDER");
		repository.create(queue);
				
	}	
	
	
}
