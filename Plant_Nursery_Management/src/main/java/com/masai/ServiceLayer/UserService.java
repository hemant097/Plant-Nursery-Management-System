package com.masai.ServiceLayer;

import com.masai.Exceptions.UserAlreadyExists;
import com.masai.models.User;

public interface UserService {

	public User saveUer(User user) throws UserAlreadyExists;
	
	public User updateUserCredential(User user,String key) throws UserAlreadyExists;
	
	public String userLogout(String key)  throws UserAlreadyExists;
}
