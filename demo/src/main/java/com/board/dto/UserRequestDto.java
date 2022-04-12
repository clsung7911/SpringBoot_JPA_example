package com.board.dto;

import com.board.entity.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {
	private String userId; // 사용자ID
	private String userPw; // 비밀번호
	private String userNm; // 사용자명
	private String userEmail; // 이메일
	private String userTel; // 전화번호
	private char useAt; // 사용여부
	
	public User toEntity() {
		return User.builder()
				.userId(userId)
				.userId(userId)
				.userId(userId)
				.userId(userId)
				.userId(userId)
				.userId(userId)
				.useAt(useAt)
				.build();
	}
}
