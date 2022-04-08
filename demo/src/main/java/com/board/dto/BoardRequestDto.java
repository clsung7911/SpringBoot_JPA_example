package com.board.dto;

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
public class BoardRequestDto {
	private String title; // 제목
    private String contents; // 내용
    private String writer; // 작성자
    private char delYn; // 삭제 여부

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
