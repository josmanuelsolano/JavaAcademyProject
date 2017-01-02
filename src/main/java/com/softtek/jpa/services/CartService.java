package com.softtek.jpa.services;

import java.util.List;

import com.softtek.jpa.domain.CartEntity;

public interface CartService {
	
List<CartEntity> findAllCarts();
	
	CartEntity create(CartEntity cart);
	
	CartEntity findByCartKey(Long cart);
	
	boolean update(CartEntity cart);//TODO remember catch the exception
	
	CartEntity delete(Long id);//TODO remember catch the exception

}
