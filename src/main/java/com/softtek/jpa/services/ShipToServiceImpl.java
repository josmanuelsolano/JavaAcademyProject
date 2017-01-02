package com.softtek.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.jpa.domain.ShipToEntity;
import com.softtek.jpa.repository.ShipToRepository;

@Service
public class ShipToServiceImpl implements ShipToService{
	
	@Autowired
	private ShipToRepository ShipToRepository;

	@Override
	public List<ShipToEntity> findAllShipTos() {
		return ShipToRepository.findAll();
	}

}
