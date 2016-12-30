package com.softtek.jpa.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softtek.jpa.domain.UserEntity;
import com.softtek.jpa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserEntity> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity create(UserEntity user) {
		return null;
	}
	
	@Override
	public UserEntity findById(String username) {
		return userRepository.findOne(username);
	}

	@Override
	public boolean update(UserEntity user) {
		logger.info("USER FROM CONTROLLER: " + user.getName() );
		if (this.isValidUser(user)) {
			UserEntity updatedUser = userRepository.findOne(user.getUsername());
			updatedUser.setName(user.getName());
			updatedUser.setUserRole(user.getUserRole());
			updatedUser.setActive(user.getActive());
			userRepository.save(updatedUser);
			return true;
		}
		return false;
		
	}

	@Override
	public UserEntity delete(int id) {
		return null;
	}
	
	private Boolean isValidUser(UserEntity user) {
		
		if (user.getUsername() == null 
				|| user.getPassword() == null
				|| user.getPassword().isEmpty()
				|| user.getName() == null
				|| user.getName().isEmpty()
				|| user.getUserRole().getUserRoleId() == null 
				|| user.getActive() == null) {
			return false;
		}
		
		return true;
	}

}
