package com.wim.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wim.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

	
}
