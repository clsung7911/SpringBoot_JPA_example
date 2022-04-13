package com.board.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.board.entity.UserInfo;

@Mapper
public interface UserMapper {

	public Optional<UserInfo> findById(String userId);
}
