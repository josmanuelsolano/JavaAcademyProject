package com.softtek.jpa.services;

import java.util.List;

import com.softtek.jpa.domain.UserEntity;
import com.softtek.jpa.domain.UserRoleEntity;

public interface UserRoleService {
	
List<UserRoleEntity> findAllUserRole();
	
	UserRoleEntity create(UserRoleEntity userRole);
	
	UserRoleEntity findById(String userRoleId);
	
	UserRoleEntity update(UserEntity userRoleId);//TODO remember catch the exception
	
	UserRoleEntity delete(String userRoleId);//TODO remember catch the exception

}
