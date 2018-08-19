package com.training.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.user.model.User;
import com.training.user.service.UserService;

import validation.CustomValidator;

@Controller
public class RegistrationController {
	
	
	@Autowired
	private CustomValidator customValidator;

	 @Autowired
	  public UserService userService;
	 
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
	    
		  ModelAndView mav = new ModelAndView("register");
	   
		  mav.addObject("user", new User());
	    
		  return mav;
	  
	  }
	  
	  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
	  public ModelAndView addUser(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("user") User user, BindingResult result) {
	  
		  customValidator.validate(user, result);
		  
		  if( result.hasErrors() ) {
			  
			  return new ModelAndView("register");
			  
		  }
		  
		  userService.register(user);
	  
		  return new ModelAndView("login","message"," Succesfullu Registered " + user.getFirstname());
	 
	  }

}
