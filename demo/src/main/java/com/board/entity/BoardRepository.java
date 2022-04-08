package com.board.entity;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BoardRepository extends JpaRepository<Board, Integer>{ // Entity Ÿ��, PK ������Ÿ��
	/**
     * �Խñ� ����Ʈ ��ȸ - (���� ���� ����)
     */
    List<Board> findAllByDelYn(final char delYn, final Sort sort);
}
