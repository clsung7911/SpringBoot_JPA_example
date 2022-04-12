package com.board.dto;

import java.time.LocalDateTime;

import com.board.entity.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponseDto {
	private String userId; // �����ID
	private String userPw; // ��й�ȣ
	private String userNm; // ����ڸ�
	private String userEmail; // �̸���
	private String userTel; // ��ȭ��ȣ
	private char useAt; // ��뿩��
	private LocalDateTime registDt = LocalDateTime.now(); // ������
	private String updtId; // ������ID
    private LocalDateTime updtDt; // ������

    public UserResponseDto(User entity) {
    	this.userId = entity.getUserId();
		this.userPw = entity.getUserPw();
		this.userNm = entity.getUserNm();
		this.userEmail = entity.getUserEmail();
		this.userTel = entity.getUserTel();
		this.useAt = entity.getUseAt();
		this.registDt = entity.getRegistDt();
		this.updtId = entity.getUpdtId();
		this.updtDt = entity.getUpdtDt();
    }
}
