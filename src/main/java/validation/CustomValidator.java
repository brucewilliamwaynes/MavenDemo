package validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		//returns false
		return false;
	}

	public void validate(Object object , Errors errors) {
		// Validation override
		ValidationUtils.rejectIfEmptyOrWhitespace( errors , "username", "required.username", "Choose your username Mr. Wayne -_-");
		
		ValidationUtils.rejectIfEmptyOrWhitespace( errors , "password", "required.password", "Don't you want it to be a secret");
		
		ValidationUtils.rejectIfEmptyOrWhitespace( errors , "firstname", "required.firstname", "Tell me what should I call you by ?");
		
		ValidationUtils.rejectIfEmptyOrWhitespace( errors , "lastname", "required.lastname", "Last Name is Compulsory");
		
		ValidationUtils.rejectIfEmptyOrWhitespace( errors , "email", "required.email", "Give me your gmail");
		
		ValidationUtils.rejectIfEmptyOrWhitespace( errors , "address", "required.address", "You got to live somewhere");
		
		ValidationUtils.rejectIfEmptyOrWhitespace( errors , "phone", "required.phone", "We need to talk !");
		
		
		
		
	}
	
	

}
