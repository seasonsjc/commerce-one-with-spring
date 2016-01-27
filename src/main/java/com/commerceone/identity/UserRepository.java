package com.commerceone.identity;

import com.commerceone.shared.repository.BaseRepository;

public class UserRepository extends BaseRepository<User,Long> {
	
	public UserRepository() {
		super(User.class);
	}

	
	
}
