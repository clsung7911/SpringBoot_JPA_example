package com.board.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.board.dto.BoardResponseDto;
import com.board.paging.CommonPaging;

//MyBatis�� @Mapper�� ����� �������̽��� ����� XML Mapper���� �޼����� ������ SQL�� ã�� ������ ����
@Mapper
public interface BoardMapper {
	/**
     * �Խñ� �� ��ȸ
     */
    int count(final CommonPaging params);

    /**
     * �Խñ� ����Ʈ ��ȸ
     */
    List<BoardResponseDto> findAll(final CommonPaging params);
}
