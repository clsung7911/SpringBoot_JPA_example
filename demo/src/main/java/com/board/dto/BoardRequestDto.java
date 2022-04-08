package com.board.dto;

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
public class BoardRequestDto {
	private String title; // ����
    private String contents; // ����
    private String writer; // �ۼ���
    private char delYn; // ���� ����

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .contents(contents)
                .writer(writer)
                .hits(0)
                .delYn(delYn)
                .build();
    }
}
