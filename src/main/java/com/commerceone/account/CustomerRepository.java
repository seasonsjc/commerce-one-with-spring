package com.commerceone.account;

import com.commerceone.shared.repository.BaseRepository;

public class CustomerRepository extends BaseRepository<Customer,Long> {
	
	public CustomerRepository() {
		super(Customer.class);
	}

	
	
}
