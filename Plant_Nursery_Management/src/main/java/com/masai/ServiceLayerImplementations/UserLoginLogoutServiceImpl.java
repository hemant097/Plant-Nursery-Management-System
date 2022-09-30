package com.masai.ServiceLayerImplementations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.UserAlreadyExists;
import com.masai.Repository.UserDAO;
import com.masai.Repository.UserSessionDAO;
import com.masai.ServiceLayer.UserLoginLogoutService;
import com.masai.models.User;
import com.masai.models.UserDTO;
import com.masai.models.UserSession;

import net.bytebuddy.utility.RandomString;

@Service
public class UserLoginLogoutServiceImpl implements UserLoginLogoutService {

	@Autowired
	private UserSessionDAO usersessionDao;
	
	@Autowired
	private UserDAO uDao;

	@Override
	public String userLogin(UserDTO userDTO) throws UserAlreadyExists  {

		User user = uDao.findByMobile(userDTO.getMobile());

		if(user==null) {
			return "Enter a valid mobile number";
		}
		Optional<UserSession> isUserPresent = usersessionDao.findById(user.getUserId());
		
		if(isUserPresent.isPresent()) {
			throw new UserAlreadyExists("User already logged in");
		}
		
		if(user.getPassword().equals(userDTO.getPassword())) {
			String key = RandomString.make(6);
			UserSession userSession = new UserSession(user.getUserId(), key,LocalDateTime.now());
			usersessionDao.save(userSession);
			return userSession.toString();
			
		}else return "Password does not match";
	
	}


	

}
