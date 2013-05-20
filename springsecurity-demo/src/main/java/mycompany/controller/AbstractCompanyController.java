package mycompany.controller;

import mycompany.service.UserService;
import mycompany.service.UsernameHolder;

import org.springframework.web.servlet.mvc.AbstractController;

public abstract class AbstractCompanyController extends AbstractController {
	
	protected UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getUsername() {
		return UsernameHolder.getAuthenticatedUsername();
	}
}
