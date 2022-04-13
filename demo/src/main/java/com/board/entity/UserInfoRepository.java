package com.board.entity;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, String>{
	Optional<UserInfo> findById(String userId);
}
