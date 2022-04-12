package com.board.dto;

import com.board.entity.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequestDto {
	private String userId; // �����ID
	private String userPw; // ��й�ȣ
	private String userNm; // ����ڸ�
	private String userEmail; // �̸���
	private String userTel; // ��ȭ��ȣ
	private char useAt; // ��뿩��
	
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
