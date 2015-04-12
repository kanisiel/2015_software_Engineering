package dao;

import javax.sql.DataSource;

import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;


public class UserDaoImpl implements UserDao {
	private static final String SELECT_BY_USERID_PASSWORD = "SELECT user_id, password FROM user_account WHERE user_id = ? AND password = ?";
	//private SimpleJdbcTemplate stemplate;
	private JdbcTemplate template;
	
	
	private DataSource dataSource;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
	//	this.stemplate = new SimpleJdbcTemplate(dataSource);
		this.template = new JdbcTemplate(dataSource);
	}
	
	public User findByUserIDAndPassword(String userID, String password){
		RowMapper<User> mapper = new BeanPropertyRowMapper<User>(User.class);
		//this.template.queryForObject(SELECT_BY_USERID_PASSWORD, mapper, userID, password);
		return this.template.queryForObject(SELECT_BY_USERID_PASSWORD, mapper, userID, password);
	}
}
