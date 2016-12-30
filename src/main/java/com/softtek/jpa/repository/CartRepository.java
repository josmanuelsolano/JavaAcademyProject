package com.softtek.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.jpa.domain.CartEntity;

public interface CartRepository extends JpaRepository<CartEntity, Long>{

}
