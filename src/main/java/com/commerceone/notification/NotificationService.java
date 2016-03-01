package com.commerceone.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.sales.Order;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	public NotificationService() {
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void sendMailToSupplier (Order order) {
	
		MailBox mailBox = new MailBox();
		repository.save(mailBox);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)	
	public void sendMailToCustomer (Order order) {
//		if (true) 
//			throw new RuntimeException("Não foi possivel enfilerar o mail para customer");
//		
		MailBox mailBox = new MailBox();
		repository.save(mailBox);
	}	
	
	
}
