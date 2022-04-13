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

	@Id // PK임을 의미
	private String userId; // 사용자ID
	private String userPw; // 비밀번호
	private String userNm; // 사용자명
	private String userEmail; // 이메일
	private String userTel; // 전화번호
	private char useAt; // 사용여부
	private char sex; // 성별
	private LocalDateTime registDt; // 등록일시
	private String updtId; // 수정자ID
	private LocalDateTime updtDt; //  수정일시
	
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
