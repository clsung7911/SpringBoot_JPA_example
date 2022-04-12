package com.board.dto;

import java.time.LocalDateTime;

import com.board.entity.Board;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity Ŭ�������� ���̺� �Ǵ� ���ڵ� ������ ������ ��û(Request)/����(Response) ����� �ȵǱ� ������
 * �ݵ�� ���� Ŭ���� ���� �ʿ��ϴ�
 * @author SJ
 *
 */

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardResponseDto {
	private Integer boardId; // PK
    private String title; // ����
    private String contents; // ����
    private String userId; // �ۼ���ID
    private String userNm; // �ۼ��ڸ�
    private int hits; // ��ȸ ��
    private char delYn; // ���� ����
    private LocalDateTime registDt = LocalDateTime.now(); // ������
    private LocalDateTime updtDt; // ������
    
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
