package com.training.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.training.user.model.User;
import com.training.user.service.UserService;

@Controller
public class ResetPasswordController {

	@Autowired
	UserService userService;
	
	
	@RequestMapping( value = "/resetPassword" , method = RequestMethod.GET )
	public ModelAndView showResetPassword( @RequestParam("resetToken") String token ,  HttpServletRequest request , HttpServletResponse response ){
		
		ModelAndView mav = null;
		
		User currentUser = userService.getUser( token );
		
		if( null != currentUser  ){
			
			
			
		}
		
		
		return mav;
		
	}
	
}
