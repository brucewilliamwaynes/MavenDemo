package com.training.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping( value = "/home" , method = RequestMethod.GET )
	public ModelAndView showHome( HttpServletRequest request , HttpServletResponse response  ) {
		
		String username = (String )request.getSession().getAttribute( "username" );
			
		return new ModelAndView( "home" , "message" , "Password Successfully updated for " + username );
		
	}
	
	
}
