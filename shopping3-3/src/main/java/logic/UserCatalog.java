package logic;

public interface UserCatalog {

	User getUserByUserIDAndPassword(String userID, String password);
}
