package com.commerceone.event;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.shared.repository.BaseRepository;

@Repository
public class EventRepository extends BaseRepository<EventLog, Long> {
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public EventLog create(EventLog entity) {
		//BEGIN TRANSACTION
		
		return super.create(entity);
		
		//COMMIT TRANSACTION
	}

}
