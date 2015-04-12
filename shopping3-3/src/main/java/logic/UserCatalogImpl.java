package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import dao.UserDao;
import logic.User;


public class UserCatalogImpl implements UserCatalog {
	
	
	private UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public User getUserByUserIDAndPassword(String userID, String password){
		return new User("1","1");
		//return this.userDao.findByUserIDAndPassword(userID, password);
	}
}
