package com.board.dto;

import java.time.LocalDateTime;

import com.board.entity.UserInfo;

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
	private char sex; // 성별
	private LocalDateTime registDt = LocalDateTime.now(); // 등록일시
	
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
