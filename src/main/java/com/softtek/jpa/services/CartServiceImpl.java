package com.softtek.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.jpa.domain.CartEntity;
import com.softtek.jpa.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public List<CartEntity> findAllCarts() {
		return cartRepository.findAll();
	}

	@Override
	public CartEntity create(CartEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CartEntity findById(Long cart_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(CartEntity user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CartEntity delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
