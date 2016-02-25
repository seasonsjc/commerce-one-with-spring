package com.commerceone.sales;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.commerceone.shared.repository.BaseRepository;

@Repository
@Transactional
public class OrderRepository extends BaseRepository<Order, Long> {

}
