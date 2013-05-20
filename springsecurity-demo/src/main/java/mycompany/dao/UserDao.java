package mycompany.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mycompany.model.User;

import org.springframework.jdbc.core.RowMapper;

public class UserDao extends AbstractDao {
	@SuppressWarnings("unchecked")
	public User getByUsername(String username) {
		String sql = "select username, name, manager_id, salary from users where username = ?";
		List result = this.jdbcTemplate.query(sql, new Object[] {username}, new UserRowMapper());
		return (User) (result.size() > 0 ? result.get(0) : null);
	}
	
	public void updateSalary(User user, BigDecimal percent) {
		BigDecimal oldSalary = user.getSalary();
		percent = BigDecimal.ONE.add(percent);
		BigDecimal newSalary = oldSalary.multiply(percent);
		String sql = "update users set salary = ? where username = ?";
		this.jdbcTemplate.update(sql, new Object[] {newSalary, user.getUsername()});
	}
	
	public List<User> getManaged(String username) {
		String sql = "select username, name, manager_id, salary from users where manager_id = ?";
		return this.jdbcTemplate.query(sql, new Object[] {username}, new UserRowMapper());
	}
	
	public List<User> list() {
		String sql = "select username, name, manager_id, salary from users";
		return this.jdbcTemplate.query(sql, new UserRowMapper());
	}
	
	private class UserRowMapper implements RowMapper {

		@Override
		public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			User user = new User();
			user.setUsername(resultSet.getString("username"));
			user.setName(resultSet.getString("name"));
			user.setManagerId(resultSet.getString("manager_id"));
			user.setSalary(resultSet.getBigDecimal("salary"));
			return user;
		}
		
	}
}
