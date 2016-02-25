package com.commerceone.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.sales.Order;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository repository;
	
	public NotificationService() {
	}

	@Transactional	
	public void sendMailToSupplier (Order order) {
	
		MailBox mailBox = new MailBox();
		repository.create(mailBox);
		
	}

	@Transactional	
	public void sendMailToCustomer (Order order) {
		MailBox mailBox = new MailBox();
		repository.create(mailBox);
	}	
	
	
}
