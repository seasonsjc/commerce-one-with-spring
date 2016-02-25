package com.commerceone.billing;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.sales.Order;

@Service
public class BillingService {
	
	private static Logger logger = Logger.getLogger(BillingService.class);
	
	@Autowired
	private BillingRepository repository;

	public BillingService() {
	}	

	
	@Transactional
	public void startBillingFor(Order order) {
		
		Billing billing = new Billing ();
		billing.setType( BillingType.CREDIT_CARD );
		
		repository.create(billing);
		
	}
	
	
}
