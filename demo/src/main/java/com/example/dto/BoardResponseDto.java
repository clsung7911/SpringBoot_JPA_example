package com.example.dto;

import java.time.LocalDateTime;
import com.example.entity.Board;
import lombok.Getter;

/**
 * Entity 클래스에서 테이블 또는 레코드 역할을 하지만 요청(Request)/응답(Response) 사용이 안되기 때문에
 * 반드시 따로 클래서 생성 필요하다
 * @author SJ
 *
 */

@Getter
public class BoardResponseDto {
	private Integer id; // PK
    private String title; // 제목
    private String contents; // 내용
    private String writer; // 작성자
    private int hits; // 조회 수
    private char delYn; // 삭제 여부
    private LocalDateTime registDt = LocalDateTime.now(); // 생성일
    private LocalDateTime updtDt; // 수정일
    
    public BoardResponseDto(Board entity) {
    	this.id = entity.getId();
    	this.title = entity.getTitle();
    	this.contents = entity.getContents();
    	this.writer = entity.getWriter();
    	this.hits = entity.getHits();
    	this.delYn = entity.getDelYn();
    	this.registDt = entity.getRegistDt();
    	this.updtDt = entity.getUpdtDt();
    }
}
