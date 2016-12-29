package com.softtek.jpa.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.jpa.domain.UserEntity;
//import com.softtek.jpa.services.UserRoleService;
import com.softtek.jpa.services.UserService;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	//private UserRoleService userRoleService = new UserRoleService();

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "")
	public ModelAndView users() {

		logger.info("LIST USERS CONTROLLER");

		final List<UserEntity> users = userService.findUsers();
		ModelAndView model = new ModelAndView("users/users");
		model.addObject("users", users);
		return model;
	}

//	@RequestMapping(value = "/edit/{username}")
//	public String edit(ModelMap model, @PathVariable("username") String username) {
//	
//	UserEntity user = userService.findOne(username);
//	List<UserRoleEntity> userRoles = userRoleService.list();
//	model.addAttribute("user", user);
//	model.addAttribute("userRoles", userRoles);
//	return "users/edit";
//	 }
//	
//	@RequestMapping(value = "/update")
//	public ModelAndView update(@ModelAttribute("user") UserEntity user,
//	@ModelAttribute("role") UserRoleEntity userRole) {
//	
//	 logger.info(userRole.toString());
//	 user.setUserRole(null);
//	 logger.info(user.toString());
//	 if (userService.update(user)) {
//	 return this.users();
//	 }
//	
//	 ModelAndView model = new ModelAndView("users/edit");
//	 List<UserRoleEntity> userRoles = userRoleService.list();
//	 model.addObject("userRoles", userRoles);
//	 model.addObject("user", user);
//	 model.addObject("msg", new String("Please check the required fields."));
//	 return model;
//	 }

}
