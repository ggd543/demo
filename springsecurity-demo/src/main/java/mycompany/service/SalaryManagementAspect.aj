package mycompany.service;

import mycompany.dao.UserDao;
import mycompany.model.User;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.intercept.aspectj.AspectJCallback;
import org.springframework.security.access.intercept.aspectj.AspectJMethodSecurityInterceptor;

public aspect SalaryManagementAspect {
	private AspectJMethodSecurityInterceptor securityInterceptor;

	private UserDao userDao;

	pointcut salaryChange(): target(UserService)
	&& execution(public void raiseSalary(..)) && !within(SalaryManagementAspect);

	Object around(): salaryChange() {
		if (this.securityInterceptor == null) {
			return proceed();
		}
		AspectJCallback callback = new AspectJCallback() {
			public Object proceedWithObject() {
				return proceed();
			}
		};
		Object[] args = thisJoinPoint.getArgs();
		String employee = (String) args[0];
		User user = userDao.getByUsername(employee);
		String currentUser = UsernameHolder.getAuthenticatedUsername();
		if (!currentUser.equals(user.getManagerId())) {
			throw new AccessDeniedException("Only the direct manager can change the salary.");
		}

		return this.securityInterceptor.invoke(thisJoinPoint, callback);
	}

	public void setSecurityInterceptor(
			AspectJMethodSecurityInterceptor securityInterceptor) {
		this.securityInterceptor = securityInterceptor;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
