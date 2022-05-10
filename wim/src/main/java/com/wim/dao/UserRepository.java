package com.wim.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wim.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String> {

	public Optional<UserEntity> findBykakaEmail(String kakaoEmail);

}
