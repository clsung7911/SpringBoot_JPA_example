package com.board.entity;

import org.springframework.data.jpa.repository.JpaRepository;



public interface BoardRepository extends JpaRepository<Board, Integer>{ // Entity 타입, PK 데이터타입
	
}
