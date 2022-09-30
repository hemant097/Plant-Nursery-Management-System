package com.masai.ServiceLayer;

import com.masai.Exceptions.UserAlreadyExists;
import com.masai.models.UserDTO;
import com.masai.models.UserSession;

public interface UserLoginLogoutService {
	
	public String userLogin(UserDTO userdto) throws UserAlreadyExists;
	
}
