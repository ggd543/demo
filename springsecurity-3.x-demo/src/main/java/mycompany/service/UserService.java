package mycompany.service;

import java.math.BigDecimal;
import java.util.List;

import mycompany.dao.UserDao;
import mycompany.model.User;

public class UserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getByUsername(String username) throws ServiceException {
		if (username == null) {
			throw new ServiceException(new IllegalArgumentException("Username can not be null."));
		}
		return userDao.getByUsername(username);
	}
	
	public void raiseSalary(String username) throws ServiceException {
		User user = getByUsername(username);
		if (user == null) {
			throw new ServiceException(new IllegalArgumentException("No such user."));
		}
		BigDecimal percent = BigDecimal.valueOf(0.2);
		userDao.updateSalary(user, percent);
	}
	
	public List<User> getManaged(String username) throws ServiceException {
		if (username == null) {
			throw new ServiceException(new IllegalArgumentException("Username can not be null."));
		}
		return userDao.getManaged(username);
	}
	
	public List<User> list() throws ServiceException {
		return userDao.list();
	}
}
