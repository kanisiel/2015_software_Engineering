package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;


public class ShopImpl implements Shop {
	
	
	private UserCatalogImpl userCatalog;
	
	@Autowired
	public void setUserCatalog(UserCatalogImpl userCatalog) {
		this.userCatalog = userCatalog;
	}
	
	public User getUserByUserIDAndPassword(String userID, String password){
		if(this.userCatalog != null){
			User test = this.userCatalog.getUserByUserIDAndPassword(userID, password);
			if(test==null){
				System.out.println("error on shopimpl");
				return null;
			} else { 
				return this.userCatalog.getUserByUserIDAndPassword(userID, password);
			}
		} else {
			System.out.println("error on userCatalog set");
			return null;
		}
	}
}
