package com.training.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.user.dao.UserDao;
import com.training.user.model.EmailID;
import com.training.user.model.Login;
import com.training.user.model.User;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	
	public void register(User user) {
		// Register User
		userDao.register(user);
		
	}

	public User validateUser(Login login) {
		// Validate User
		
		User currentUser = userDao.validateUser(login);
		
		return currentUser;
	
	}

	public boolean emailIDExists(EmailID emailID) {
		// check if email ID Exists
		
		return userDao.emailIDExists(emailID.getEmailID());
		
	}

}
