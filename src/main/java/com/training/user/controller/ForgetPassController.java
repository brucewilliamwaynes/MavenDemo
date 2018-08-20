package com.training.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.training.user.model.EmailID;
import com.training.user.service.UserService;

import validation.EmailIDValidator;

@Controller
public class ForgetPassController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailIDValidator emailIDValidator;
	
	
	private static final Logger logger = LogManager.getLogger( ForgetPassController.class );
	
	@RequestMapping(value = "/forgetPass" , method = RequestMethod.GET )
	public ModelAndView showForgetPass( HttpServletRequest request , HttpServletResponse respsonse ) {
		
		logger.info( "Inside Forget Password Class");
		
		return new ModelAndView("forgetPassword", "emailID", new EmailID());
		
	}
	
	
	@RequestMapping(value="/resetPasswordProcess" , method = RequestMethod.POST )
	public ModelAndView forgetPassProcess( HttpServletRequest request , HttpServletResponse response , @ModelAttribute ( "emailID" ) EmailID emailID , BindingResult result ) {
		
		ModelAndView mav = null;
		
		logger.info( "Inside Reset Password" );
		
		emailIDValidator.validate( emailID, result );
		
		if( result.hasErrors() ) {
			
			logger.error( "Filled Empty Email ID" );
			
			mav = new ModelAndView( "forgetPassword" );			
			
		}
		
		else {
		
			if( userService.emailIDExists(emailID) ) {
				//Redirect to where we reset password via java mail
				
				
				
			}
			
			else {
				
				logger.error( "Wrong Email ID , doesn't exists !" );

				mav = new ModelAndView("forgetPassword");
				
			}
			
		}
		
		return mav;
		
	}

}
