package com.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserInfo {

	@Id // PK���� �ǹ�
	private String userId; // �����ID
	private String userPw; // ��й�ȣ
	private String userNm; // ����ڸ�
	private String userEmail; // �̸���
	private String userTel; // ��ȭ��ȣ
	private char useAt; // ��뿩��
	private char sex; // ����
	private LocalDateTime registDt; // ����Ͻ�
	private String updtId; // ������ID
	private LocalDateTime updtDt; //  �����Ͻ�
	
	@Builder
	public UserInfo(String userId, String userPw, String userNm, String userEmail, String userTel, char useAt, char sex) {
		this.userId = userId;
		this.userPw = userPw;
		this.userNm = userNm;
		this.userEmail = userEmail;
		this.userTel = userTel;
		this.useAt = useAt;
		this.sex = sex;
	}
	
}
