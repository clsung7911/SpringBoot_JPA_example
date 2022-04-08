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
	//JPA Repository 인터페이스
	private final BoardRepository boardRepository;

	/**
     * 게시글 리스트 조회
     */
    public List<BoardResponseDto> findAll() {
    	//sort 객체는 ORDER BY id DESC, registDt DESC을 의미
        Sort sort = Sort.by(Direction.DESC, "id", "registDt");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }
    
    /**
    * 게시글 상세정보 조회
    */
   @Transactional
   public BoardResponseDto findById(final int id) {
       Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
       entity.increaseHits();
       return new BoardResponseDto(entity);
   }
   
   /**
    * 게시글 리스트 조회 - (삭제 여부 기준)
    */
   public List<BoardResponseDto> findAllByDelYn(final char delYn) {
       Sort sort = Sort.by(Direction.DESC, "id", "registDt");
       List<Board> list = boardRepository.findAllByDelYn(delYn, sort);
       return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
   }


    /**
     * 게시글 생성
     */
	//JPA를 사용한다면, 서비스(Service) 클래스에서 필수적으로 사용되어야 하는 어노테이션
	//일반적으로 메서드 레벨에 선언하게 되며, 메서드의 실행, 종료, 예외를 기준으로 각각 실행(begin), 종료(commit), 예외(rollback)를 자동으로 처리
    @Transactional
    public Integer save(final BoardRequestDto params) {
    	// Entity 클래스에서는 절대 요청/응답 사용 안되기에 DTO에서 실행
        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    /**
     * 게시글 수정
     */
    @Transactional
    public Integer update(final int id, final BoardRequestDto params) {
    	// Entity 클래스의 레코드를 가지고 update 처리하는 기능
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.update(params.getTitle(), params.getContents(), params.getWriter());
        return id;
    }
    
    /**
     * 게시글 삭제
     */
    @Transactional
    public Integer delete(final int id) {
        Board entity = boardRepository.findById(id).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
        entity.delete();
        return id;
    }
}
