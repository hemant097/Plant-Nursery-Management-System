package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Order;
@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {

	
}
