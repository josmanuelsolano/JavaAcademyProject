package com.softtek.jpa.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softtek.jpa.domain.UserEntity;
import com.softtek.jpa.domain.UserRoleEntity;
import com.softtek.jpa.services.UserRoleService;
import com.softtek.jpa.services.UserService;

@Controller
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "", method=RequestMethod.GET)
	public ModelAndView users() {
		logger.info("LIST USERS CONTROLLER");
		ModelAndView model = new ModelAndView("users");
		final List<UserEntity> users = userService.findAllUsers();
		model.addObject("users", users);	
		return model;
	}

	@RequestMapping(value = "/edit/{username}", method=RequestMethod.GET)
	public ModelAndView edit(@PathVariable("username") String username) {
		ModelAndView model = new ModelAndView("userEdit");
		UserEntity user = userService.findById(username);
		model.addObject("user", user);
		List<UserRoleEntity> userRoles = userRoleService.findAllUserRole();
		model.addObject("userRoles", userRoles);
		return model;
	 }
	
	@RequestMapping(value = "update", method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("user") UserEntity user,
			@ModelAttribute("role") String userRole) {
			user.setUserRole(new UserRoleEntity(userRole, null));
		 if (userService.update(user)) {
			 ModelAndView model = new ModelAndView("redirect:/users");
			 return model;
		 }
	
		 ModelAndView model = new ModelAndView("userEdit");
		 List<UserRoleEntity> userRoles = userRoleService.findAllUserRole();
		 model.addObject("userRoles", userRoles);
		 model.addObject("user", user);
		 model.addObject("msg", new String("Please check the required fields."));
		 return model;
	 }

}
