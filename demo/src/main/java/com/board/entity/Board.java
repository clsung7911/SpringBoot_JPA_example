package com.board.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Entity 클래스는 테이블(Table) 또는 레코드(Record) 역할을 하는 데이터베이스 그 자체
 * 요청(Request)이나 응답(Response)에 사용되어서는 안된다 
 * @author SJ
 *
 */

//해당 클래스에 포함된 멤버 변수의 모든 getter 메서드를 생성
@Getter
//해당 클래스의 기본 생성자를 생성해 주는 어노테이션
//access 속성을 이용해서 동일한 패키지 내의 클래스에서만 객체를 생성할 수 있도록 제어
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//해당 클래스가 테이블과 매핑되는 JPA의 엔티티(Entity) 클래스임을 의미
//기본적으로 클래스명(Camel Case)을 테이블명(Snake Case)으로 매핑
//예를 들어, user_role이라는 테이블은 UserRole이라는 이름의 클래스로 네이밍
//혹시라도 클래스명과 테이블명이 다를 수밖에 없는 상황에서는 클래스 레벨에 @Table을 선언
//@Table(name = "user_role")과 같이 name 속성을 이용해서 처리
@Entity
@SequenceGenerator(name="board_pk_generator", sequenceName = "board_seq", initialValue = 1, allocationSize = 1)
public class Board {

    @Id // PK임을 의미
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_pk_generator") // PK 생성시
    private Integer boardId; // PK
    private String title; // 제목
    private String contents; // 내용
    private String userId; // 작성자ID
    private String userNm; // 작성자명
    private int hits; // 조회 수
    private char delYn; // 삭제 여부
    private LocalDateTime registDt = LocalDateTime.now(); // 생성일
    private LocalDateTime updtDt; // 수정일

    //롬복에서 제공해주는 빌더라는 기능으로, 생성자 대신에 이용하는 패턴
    @Builder
    public Board(String title, String contents, String userId, String userNm, int hits, char delYn) {
        this.title = title;
        this.contents = contents;
        this.userId = userId;
        this.userNm = userNm;
        this.hits = hits;
        this.delYn = delYn;
    }
    
    //update 쿼리를 실행하는 로직이 없음 -> JPA에서는 영속성이란 컨텍스트라는 개념으로 자동 실행
    public void update(String title, String contents, String userId) {
    	this.title = title;
    	this.contents = contents;
    	this.userId = userId;
    	this.updtDt = LocalDateTime.now();
    }
    
    /**
     * 조회 수 증가
     */
    public void increaseHits() {
        this.hits++;
    }

    /**
     * 게시글 삭제
     */
    public void delete() {
        this.delYn = 'Y';
    }

}
