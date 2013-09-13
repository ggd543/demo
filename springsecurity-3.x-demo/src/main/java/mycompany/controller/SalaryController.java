package mycompany.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mycompany.model.User;

import org.springframework.web.servlet.ModelAndView;

public class SalaryController extends AbstractCompanyController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String requestMethod = request.getMethod();
		if ("GET".equals(requestMethod)) {
			ModelAndView mav = new ModelAndView("salary");
			String username = getUsername();
			List<User> users = userService.getManaged(username);
			mav.addObject("users", users);
			return mav;
		} else if ("POST".equals(requestMethod)) {
			String employee = request.getParameter("employee");
			userService.raiseSalary(employee);
			ModelAndView mav = new ModelAndView("redirect:salary.do");
			return mav;
		} 
		response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
		return null;
	}

}
