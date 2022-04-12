package com.board.dto;

import java.time.LocalDateTime;

import com.board.entity.Board;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity 클래스에서 테이블 또는 레코드 역할을 하지만 요청(Request)/응답(Response) 사용이 안되기 때문에
 * 반드시 따로 클래서 생성 필요하다
 * @author SJ
 *
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponseDto {
	private Integer boardId; // PK
    private String title; // 제목
    private String contents; // 내용
    private String userId; // 작성자ID
    private String userNm; // 작성자명
    private int hits; // 조회 수
    private char delYn; // 삭제 여부
    private LocalDateTime registDt = LocalDateTime.now(); // 생성일
    private LocalDateTime updtDt; // 수정일
    
    public BoardResponseDto(Board entity) {
    	this.boardId = entity.getBoardId();
    	this.title = entity.getTitle();
    	this.contents = entity.getContents();
    	this.userId = entity.getUserId();
    	this.userNm = entity.getUserNm();
    	this.hits = entity.getHits();
    	this.delYn = entity.getDelYn();
    	this.registDt = entity.getRegistDt();
    	this.updtDt = entity.getUpdtDt();
    }
}
