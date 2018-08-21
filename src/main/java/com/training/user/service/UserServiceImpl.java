package com.training.user.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;

import com.training.user.dao.UserDao;
import com.training.user.model.EmailID;
import com.training.user.model.Login;
import com.training.user.model.User;

import Utility.EmailUtility;

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

	public boolean forgotPasswordReset(EmailID emailID) {
		//Forgot Password Procedure
		
		User currentUser = userDao.findUser(emailID);
		
		if( currentUser != null ) {
			
			final String fromEmail = "shravanbossu@gmail.com	";
			
			final String password = "lavadekebaal";
			
			final String subject = "Reset Password Link";
			
			String token = EmailUtility.createToken( currentUser );
			
			String redirectURL = "http://localhost:8080/MavenDemo/resetPassword?resetToken=" + token;
			
			String body = " Hey , Please press on the link below to redirect ! \n" + redirectURL;
			
			final String toEmail = currentUser.getEmail();
			
			Properties props = new Properties();
			
			props.put( "mail.smtp.host" , "smtp.gmail.com" );
			
			props.put("mail.smtp.port", "587");
			
			props.put("mail.smtp.auth", "true");
			
			props.put("mail.smtp.starttls.enable", "true");
			
			Authenticator auth = new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromEmail, password);
				}
			};
			
			Session session = Session.getInstance(props, auth);
			
			
			EmailUtility.sendEmail(session, toEmail, subject, body);
			
			userDao.writeToken( emailID , token );
			
			return true;
		
		}
		
		return false;
		
	}

	public User getUser(String token) {
		// Get User From Token
		
		return userDao.searchFromToken( token  );
		
	}

	public void savePassword(String username, String newPassword) {
		// Save new Password for user
		
		userDao.savePassword( username , newPassword );
		
	}




	
}
