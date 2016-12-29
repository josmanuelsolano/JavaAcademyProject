package com.softtek.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.jpa.domain.UserEntity;
import com.softtek.jpa.domain.UserRoleEntity;
import com.softtek.jpa.repository.UserRoleRepository;

@Service
public class UserRoleImpl implements UserRoleService{
	
	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public List<UserRoleEntity> findAllUserRole() {
		return userRoleRepository.findAll();
	}

	@Override
	public UserRoleEntity create(UserRoleEntity userRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRoleEntity findById(String userRoleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRoleEntity update(UserEntity userRoleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRoleEntity delete(String userRoleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
