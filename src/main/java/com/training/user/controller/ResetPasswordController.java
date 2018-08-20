package com.training.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			
			HttpSession newSession = request.getSession();
			
			newSession.setAttribute( "username" , currentUser.getUsername() );
			
			return new ModelAndView( "createPassword" , "message" , "Welcome " + currentUser.getUsername() );
			
		}
		
		else {
			
			mav = new ModelAndView( "redirect:/forgetPassword" , "message" , " Invalid Link."  );
			
		}
		
		
		return mav;
		
	}
	
	@RequestMapping( value = "/savePassword" , method = RequestMethod.POST )
	public ModelAndView savePassword( HttpServletRequest request , HttpServletResponse response  ) {
		
		ModelAndView mav = null;
		
		String username = (String )request.getSession().getAttribute( "username" );
		
		userService.savePassword( username , (String) request.getAttribute( "password" ) );
		
		mav = new ModelAndView( "redirect:/home" ) ;
		
		return mav;
		
	}

}