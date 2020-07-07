package Testing;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Controllers.Controller;
import Model.Repository.ModelRepository;
import View.View;

class LoginTest {

	static ModelRepository model;
	static View view;
	static Controller ctrl;
	char correctPassword[] = {'1','2','3','4'}; 
	

	
	@BeforeAll
	public static void setup() {
		model = new ModelRepository();
		view = new View();
		ctrl = new Controller(model, view);
	}
	
	@Test
	public void loginValidationFailedWhenUserEmpty() {
		try {
			ctrl.loginValidation("", correctPassword);
			Assertions.fail("the user exist but its not true");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("User not exist", e.getMessage());
		}
	}
	
	@Test
	public void loginValidationFailedWhenUserInvalid() {
		try {
			ctrl.loginValidation("Chen Ronen", correctPassword);
			Assertions.fail("the user exist but its not true");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("User not exist", e.getMessage());
		}
	}
	
	@Test
	public void loginValidationFailedWhenPasswordEmpty() {
		char [] invalidPassword = {};
		try {
			ctrl.loginValidation("eyal", invalidPassword);
			Assertions.fail("the user exist but its not true");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("User not exist", e.getMessage());
		}
	}
	
	@Test
	public void loginValidationFailedWhenPasswordInvalid() {
		char [] invalidPassword = {'a','b','c'};
		try {
			ctrl.loginValidation("eyal", invalidPassword);
			Assertions.fail("the user exist but its not true");
		} catch(IllegalArgumentException e) {
			Assertions.assertEquals("User not exist", e.getMessage());
		}
	}
}
