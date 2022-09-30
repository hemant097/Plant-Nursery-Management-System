package com.masai.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer>{

	public List<Customer> findByMobileNumber(String mobileNumber);
}
