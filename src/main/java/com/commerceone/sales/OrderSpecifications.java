package com.commerceone.sales;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class OrderSpecifications {
	
	private OrderCriteria criteria;
	
	public OrderSpecifications( OrderCriteria criteria) {
		this.criteria = criteria;
	}
	
	public  Specification<Order> withStartDate () {
		
		return new Specification<Order>() {
			
			@Override
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (criteria.getStartDate() == null) return null;

				return cb.greaterThanOrEqualTo( root.get("createdDate")
												.as(Date.class)
												, criteria.getStartDate() );
			}
				
		};
		
	}
	
	
	public  Specification<Order> withEndDate () {
		
		return new Specification<Order>() {

			@Override
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (criteria.getEndDate() == null) return null;
				
				return cb.lessThanOrEqualTo( root.get("createdDate")
												.as(Date.class)
												, criteria.getEndDate() );
			}
				
		};
		
	}

	
	public  Specification<Order> withOrderNumber () {
		
		return new Specification<Order>() {

			@Override
			public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (criteria.getOrderNumber() == null) return null;
				
				return cb.equal( root.get("id").as(Long.class)
												
												, criteria.getOrderNumber() );
			}
				
		};
		
	}	
	
}
