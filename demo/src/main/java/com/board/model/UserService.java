package com.board.model;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.board.dto.UserRequestDto;
import com.board.entity.UserInfo;
import com.board.entity.UserInfoRepository;
import com.board.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserInfoRepository userInfoRepository;
	private final UserMapper userMapper;
	
	/**
	 * ȸ������
	 */
	public String  join(final UserRequestDto params) {
		UserInfo entity = userInfoRepository.save(params.toEntity());
		return entity.getUserId();
	}
	
	/**
	 * �ߺ����̵� ��ȸ
	 */
	public Optional<UserInfo>  findByUserId(final String id) {
		return userMapper.findById(id);
	}
}
