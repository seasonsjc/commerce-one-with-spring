package com.commerceone.sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.shared.repository.BaseRepository;


public interface OrderRepository extends JpaRepository<Order, Long> 
									 , 	JpaSpecificationExecutor<Order> {

}
