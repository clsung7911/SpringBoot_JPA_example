package com.board.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.board.dto.BoardRequestDto;
import com.board.dto.BoardResponseDto;
import com.board.model.BoardService;
import com.board.paging.CommonPaging;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

	private final BoardService boardService;

	/**
	 * 게시글 리스트 조회
	 */
	@GetMapping("/boards")
	public Map<String, Object> findAll(final CommonPaging params) {
		return boardService.findAll(params);
	}
	
	/**
     * 게시글 상세정보 조회
     */
    @GetMapping("/boards/{id}")
    public BoardResponseDto findById(@PathVariable final int id) {
        return boardService.findById(id);
    }
    
	/**
	 * 게시글 생성
	 */
	@PostMapping("/boards")
	public Integer save(@RequestBody final BoardRequestDto params) {
		return boardService.save(params);
	}

	/**
	 * 게시글 수정
	 */
	@PatchMapping("/boards/{id}")
	public Integer save(@PathVariable final int id, @RequestBody final BoardRequestDto params) {
		return boardService.update(id, params);
	}

	/**
     * 게시글 삭제
     */
    @DeleteMapping("/boards/{id}")
    public Integer delete(@PathVariable final int id) {
        return boardService.delete(id);
    }
}
