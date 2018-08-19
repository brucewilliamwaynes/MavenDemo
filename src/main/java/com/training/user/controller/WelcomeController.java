package com.training.user.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class WelcomeController {
	
	private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(WelcomeController.class);
	
	@RequestMapping("/welcome")
	public ModelAndView showWelcome(HttpServletRequest req, HttpServletResponse resp){
		
		//log debug message
		if( logger.isDebugEnabled() ) {
			
			logger.debug( "Inside GetWelcome Servlet" );
			
		}
		
		logger.error( "This is Error Message ! Something went wrong !" , new Exception( "Testing"  )  );
		
		
		
		HttpSession  session = req.getSession();
		
		String name = (String) session.getAttribute("user");
		
		return new ModelAndView("welcome", "firstname", name);
	
	}

}
