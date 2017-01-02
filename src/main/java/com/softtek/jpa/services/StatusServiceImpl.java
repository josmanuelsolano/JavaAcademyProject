package com.softtek.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.jpa.domain.StatusEntity;
import com.softtek.jpa.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService{
	
	@Autowired
	private StatusRepository statusRepository;
	
	@Override
	public List<StatusEntity> findAllStatus() {
		return statusRepository.findAll();
	}

}
