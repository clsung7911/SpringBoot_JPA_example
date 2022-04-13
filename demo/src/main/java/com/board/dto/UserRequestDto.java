package com.board.dto;

import java.time.LocalDateTime;

import com.board.entity.UserInfo;

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
	private char sex; // ����
	private LocalDateTime registDt = LocalDateTime.now(); // ����Ͻ�
	
	public UserInfo toEntity() {
		return UserInfo.builder()
				.userId(userId)
				.userPw(userPw)
				.userNm(userNm)
				.userEmail(userEmail)
				.userTel(userTel)
				.useAt('Y')
				.sex(sex)
				.registDt(registDt)
				.build();
	}
}
