package com.commerceone.sales;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.shared.repository.BaseRepository;


public interface OrderRepository extends JpaRepository<Order, Long> 
									 , 	JpaSpecificationExecutor<Order> {

	
	@Query("select new Order( id , createdDate ) from order o where id = :id")
	List<Order> findById (Long id);
	
}
