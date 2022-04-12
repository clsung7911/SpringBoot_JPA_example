package com.board.dto;

import java.time.LocalDateTime;

import com.board.entity.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponseDto {
	private String userId; // 사용자ID
	private String userPw; // 비밀번호
	private String userNm; // 사용자명
	private String userEmail; // 이메일
	private String userTel; // 전화번호
	private char useAt; // 사용여부
	private LocalDateTime registDt = LocalDateTime.now(); // 생성일
	private String updtId; // 수정자ID
    private LocalDateTime updtDt; // 수정일

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
