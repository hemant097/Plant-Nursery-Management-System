package com.masai.ServiceLayerImplementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.Exceptions.UserAlreadyExists;
import com.masai.Repository.UserDAO;
import com.masai.Repository.UserSessionDAO;
import com.masai.ServiceLayer.UserService;
import com.masai.models.User;
import com.masai.models.UserSession;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO uDao;
	
	@Autowired
	private UserSessionDAO cuserDao;

	@Override
	public User saveUser(User user) throws UserAlreadyExists {
		User u = uDao.findByMobile(user.getMobile());
		if(u==null) return uDao.save(user);
		else throw new UserAlreadyExists("User Already Exists");
	}

	@Override
	public User updateUserCredential(User user, String key) throws UserAlreadyExists {
		UserSession cuser =  cuserDao.findByUniqueId(key);
		if(cuser==null) throw new UserAlreadyExists("user not loged in");
		Optional<User> opt = uDao.findById(cuser.getUserId());
		if(opt.isEmpty()) throw new UserAlreadyExists("user not found");
		User userWithSameNumber = uDao.findByMobile(user.getMobile());
		if(userWithSameNumber!=null) throw new UserAlreadyExists("one user find with the same mobile number");
		User saveUser = uDao.save(user);
		cuserDao.save(cuser);
		uDao.save(opt.get());
		return saveUser;
	}

	@Override
	public String userLogout(String key) throws UserAlreadyExists {
		UserSession cuser =  cuserDao.findByUniqueId(key);
		if(cuser==null) throw new UserAlreadyExists("user not loged in");
		cuserDao.delete(cuser);
		return "Logged Out successfully";
	}

	

}
