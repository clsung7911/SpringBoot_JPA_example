package com.example.entity;

import org.springframework.data.jpa.repository.JpaRepository;



public interface BoardRepository extends JpaRepository<Board, Integer>{ // Entity Ÿ��, PK ������Ÿ��
	
}
