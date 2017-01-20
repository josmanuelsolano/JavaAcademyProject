package com.softtek.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.jpa.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository< UserEntity , String> {

	List<UserEntity> findAllByName(String name);
}
