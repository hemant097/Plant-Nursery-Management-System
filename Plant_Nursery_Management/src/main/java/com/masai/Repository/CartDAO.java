package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.models.Cart;

@Repository
public interface CartDAO extends JpaRepository<Cart, Integer> {
	
	@Modifying
    @Query(
            value = "truncate table Cart",
            nativeQuery = true)
	public void deleteAll();
}
