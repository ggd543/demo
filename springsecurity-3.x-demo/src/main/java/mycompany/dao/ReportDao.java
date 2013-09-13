package mycompany.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import mycompany.model.Report;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class ReportDao extends AbstractDao {

	public Report create(final Report report) {
		final String sql = "insert into reports (title, content) values (?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		this.jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] {"id"});
				ps.setString(1, report.getTitle());
				ps.setString(2, report.getContent());
				return ps;
			}
		}, keyHolder);
		Long id = keyHolder.getKey().longValue();
		report.setId(id);
		return report;
	}
	
	@SuppressWarnings("unchecked")
	public List<Report> list(String username) {
		final String sql = "select t4.* from (((acl_entry t1 left join acl_sid t2 on t1.sid = t2.id) left join acl_object_identity t3 on t1.acl_object_identity = t3.id) left join reports t4 on t3.object_id_identity = t4.id) where t2.sid = ?";
		return this.jdbcTemplate.query(sql, new Object[] {username}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
				Report report = new Report();
				report.setId(resultSet.getLong("id"));
				report.setTitle(resultSet.getString("title"));
				report.setContent(resultSet.getString("content"));
				return report;
			}
			
		});
	}
}
