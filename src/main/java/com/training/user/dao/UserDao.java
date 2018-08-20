/**
 * 
 */
package com.training.user.dao;

import com.training.user.model.EmailID;
import com.training.user.model.Login;
import com.training.user.model.User;

/**
 * @author bridgelabz
 *
 */
public interface UserDao {

	void register(User user);
	
	  User validateUser(Login login);

	boolean emailIDExists(String emailID);

	User findUser(EmailID emailID);

	boolean writeToken(String username, String token);
	
}
