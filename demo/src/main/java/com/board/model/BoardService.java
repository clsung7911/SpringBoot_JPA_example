package com.board.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.dto.BoardRequestDto;
import com.board.dto.BoardResponseDto;
import com.board.entity.Board;
import com.board.entity.BoardRepository;
import com.board.exception.CustomException;
import com.board.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	//JPA Repository �������̽�
	private final BoardRepository boardRepository;

	/**
     * �Խñ� ����Ʈ ��ȸ
     */
    public List<BoardResponseDto> findAll() {
    	//sort ��ü�� ORDER BY id DESC, registDt DESC�� �ǹ�
        Sort sort = Sort.by(Direction.DESC, "id", "registDt");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }
    
    /**
    * �Խñ� ������ ��ȸ
    */
   @Transactional
   public BoardResponseDto findById(final int id) {
       Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
       entity.increaseHits();
       return new BoardResponseDto(entity);
   }
   
   /**
    * �Խñ� ����Ʈ ��ȸ - (���� ���� ����)
    */
   public List<BoardResponseDto> findAllByDelYn(final char delYn) {
       Sort sort = Sort.by(Direction.DESC, "id", "registDt");
       List<Board> list = boardRepository.findAllByDelYn(delYn, sort);
       return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
   }


    /**
     * �Խñ� ����
     */
	//JPA�� ����Ѵٸ�, ����(Service) Ŭ�������� �ʼ������� ���Ǿ�� �ϴ� ������̼�
	//�Ϲ������� �޼��� ������ �����ϰ� �Ǹ�, �޼����� ����, ����, ���ܸ� �������� ���� ����(begin), ����(commit), ����(rollback)�� �ڵ����� ó��
    @Transactional
    public Integer save(final BoardRequestDto params) {
    	// Entity Ŭ���������� ���� ��û/���� ��� �ȵǱ⿡ DTO���� ����
        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    /**
     * �Խñ� ����
     */
    @Transactional
    public Integer update(final int id, final BoardRequestDto params) {
    	// Entity Ŭ������ ���ڵ带 ������ update ó���ϴ� ���
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContents(), params.getWriter());
        return id;
    }
    
    /**
     * �Խñ� ����
     */
    @Transactional
    public Integer delete(final int id) {
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.delete();
        return id;
    }
}
