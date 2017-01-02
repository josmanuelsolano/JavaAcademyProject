package com.softtek.jpa.services;

import java.util.List;

import com.softtek.jpa.domain.StatusEntity;

public interface StatusService {
	
	List<StatusEntity> findAllStatus();

}
