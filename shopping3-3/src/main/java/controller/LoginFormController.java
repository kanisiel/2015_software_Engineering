package controller;

import logic.Shop;
import logic.ShopImpl;
import logic.User;
import util.LoginValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
//import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginFormController {
	
	
	private Shop shopService;
	
	@ModelAttribute
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	
	private LoginValidator loginValidator;
	
	@ModelAttribute
	public void setLoginValidator(LoginValidator loginValidator) {
		this.loginValidator = loginValidator;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String toLoginView(){
		return "login";
	}
	
	@ModelAttribute
	public User setUpForm(){
		return new User();
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult bindingResult){
		
		this.loginValidator.validate(user, bindingResult);
		
		ModelAndView modelAndView = new ModelAndView();
		if(bindingResult.hasErrors()){
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
		
		try{
			//사용자 검색
			User loginUser = this.shopService.getUserByUserIDAndPassword(user.getUserId(), user.getPassword());
			
			//사용자가 있을때
			modelAndView.setViewName("loginSuccess");
			modelAndView.addObject("loginMember", loginUser);
			return modelAndView;
		} catch (EmptyResultDataAccessException e) {
			//사용자가 없을때
			bindingResult.reject("error.login.Memeber");
			modelAndView.getModel().putAll(bindingResult.getModel());
			return modelAndView;
		}
	}
}
