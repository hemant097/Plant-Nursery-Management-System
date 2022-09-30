package com.masai.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.masai.models.UserSession;

@Repository
public interface UserSessionDAO extends JpaRepository<UserSession, Integer>{
	
	   public Optional<UserSession> findById(Integer userId);
	   
	   public UserSession  findByUniqueId(String uniqueId);
	   
	   @Query("select c.Id from UserSession c where c.UserId=?1")
	   public String findByUserId(Integer userId);  
	   
	   
	}
