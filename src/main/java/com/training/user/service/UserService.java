package com.training.user.service;

import com.training.user.model.EmailID;
import com.training.user.model.Login;
import com.training.user.model.User;

public interface UserService {

	void register(User user);

	User validateUser(Login login);

	boolean emailIDExists(EmailID emailID);

	boolean forgotPasswordReset(EmailID emailID);

	User getUser(String token);

}
