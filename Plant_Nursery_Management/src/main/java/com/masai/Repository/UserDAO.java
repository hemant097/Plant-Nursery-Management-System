package com.masai.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.models.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{

	public User findByMobile(String mobile);
	
	public User findByUserId(Integer userId);

}
