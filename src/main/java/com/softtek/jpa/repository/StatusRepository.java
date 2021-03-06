package com.softtek.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softtek.jpa.domain.StatusEntity;

@Repository
public interface StatusRepository  extends JpaRepository<StatusEntity, Long>{

}
