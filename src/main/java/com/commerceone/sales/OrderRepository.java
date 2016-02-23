package com.commerceone.sales;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.shared.repository.BaseRepository;

@Repository
@Transactional
public class OrderRepository {
	// extends BaseRepository<Order, Long> {

	@PersistenceContext
	private EntityManager em;

	private Logger logger = Logger.getLogger(OrderRepository.class);

	public OrderRepository() {
		// super(Order.class);
		logger.debug(".............. OrderRepository Created");
	}

	@Transactional
	public void create(Order order) {
		em.persist(order);
	}

}
