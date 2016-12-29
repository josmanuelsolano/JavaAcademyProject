package com.softtek.jpa.services;

import java.util.List;

import com.softtek.jpa.domain.UserEntity;

public interface UserService {
	
	List<UserEntity> findAllUsers();
	
	UserEntity create(UserEntity user);
	
	UserEntity findById(String username);
	
	boolean update(UserEntity user);//TODO remember catch the exception
	
	UserEntity delete(int id);//TODO remember catch the exception
		
}
