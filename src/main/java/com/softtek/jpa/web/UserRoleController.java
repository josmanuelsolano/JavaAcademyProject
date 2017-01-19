package com.softtek.jpa.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.softtek.jpa.domain.UserRoleEntity;
import com.softtek.jpa.services.UserRoleService;

@Controller
@RequestMapping("userRoles")
public class UserRoleController {
	
	@Autowired
	private UserRoleService userRoleService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value = "userRoles", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<UserRoleEntity> userRoles() {
		return userRoleService.findAllUserRole();
	}

}
