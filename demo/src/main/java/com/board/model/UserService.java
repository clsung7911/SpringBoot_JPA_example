package com.board.model;

import org.springframework.stereotype.Service;

import com.board.dto.UserRequestDto;
import com.board.entity.User;
import com.board.entity.UserInfoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserInfoRepository userInfoRepository;
	
	/**
	 * 회원가입
	 */
	public String  insertUser(final UserRequestDto params) {
		User entity = userInfoRepository.save(params.toEntity());
		return entity.getUserId();
	}
}
