package com.softtek.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.jpa.domain.CartEntity;
import com.softtek.jpa.domain.CartKey;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, CartKey>{
	
	CartEntity findByCartKey(CartKey cartId);
	List<CartEntity> findAllByOrderByCartDetailsShipToAscAuditCreateDateAsc();

}
