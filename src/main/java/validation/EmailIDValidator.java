package validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EmailIDValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		// Nothing to Do
		return false;
	}

	public void validate(Object arg0, Errors errors) {
		//Checking if email is empty

		ValidationUtils.rejectIfEmptyOrWhitespace( errors , "emailID", "required.emailID", "Give me your gmail");
		
	}

}
