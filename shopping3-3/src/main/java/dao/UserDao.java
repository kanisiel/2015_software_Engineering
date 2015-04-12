package dao;

import logic.User;

public interface UserDao {
	User findByUserIDAndPassword(String userID, String password);
}
