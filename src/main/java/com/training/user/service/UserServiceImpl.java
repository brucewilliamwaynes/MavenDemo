package com.training.user.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.user.dao.UserDao;
import com.training.user.model.Login;
import com.training.user.model.User;

public class UserServiceImpl implements UserService{

	@Autowired
	UserDao dao;
	
	
	public void register(User user) {
		// Register User
		dao.register(user);
		
	}

	public User validateUser(Login login) {
		// Validate User
		
		User currentUser = dao.validateUser(login);
		
		return currentUser;
	
	}

}
