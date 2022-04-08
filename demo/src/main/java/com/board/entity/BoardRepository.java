package com.board.entity;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BoardRepository extends JpaRepository<Board, Integer>{ // Entity 타입, PK 데이터타입
	/**
     * 게시글 리스트 조회 - (삭제 여부 기준)
     */
    List<Board> findAllByDelYn(final char delYn, final Sort sort);
}
