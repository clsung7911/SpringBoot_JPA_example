package com.example.dto;

import java.time.LocalDateTime;
import com.example.entity.Board;
import lombok.Getter;

/**
 * Entity Ŭ�������� ���̺� �Ǵ� ���ڵ� ������ ������ ��û(Request)/����(Response) ����� �ȵǱ� ������
 * �ݵ�� ���� Ŭ���� ���� �ʿ��ϴ�
 * @author SJ
 *
 */

@Getter
public class BoardResponseDto {
	private Integer id; // PK
    private String title; // ����
    private String contents; // ����
    private String writer; // �ۼ���
    private int hits; // ��ȸ ��
    private char delYn; // ���� ����
    private LocalDateTime registDt = LocalDateTime.now(); // ������
    private LocalDateTime updtDt; // ������
    
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
