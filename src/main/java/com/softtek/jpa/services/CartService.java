package com.softtek.jpa.services;

import java.util.List;

import com.softtek.jpa.domain.CartEntity;

public interface CartService {
	
List<CartEntity> findAllCarts();
	
	CartEntity create(CartEntity user);
	
	CartEntity findById(Long cart_id);
	
	boolean update(CartEntity user);//TODO remember catch the exception
	
	CartEntity delete(int id);//TODO remember catch the exception

}
