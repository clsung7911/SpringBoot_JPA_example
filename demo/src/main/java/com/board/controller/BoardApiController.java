package com.board.controller;

import java.util.List;

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

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardApiController {

	private final BoardService boardService;

	/**
	 * �Խñ� ����Ʈ ��ȸ
	 */
	@GetMapping("/boards")
	public List<BoardResponseDto> findAll(@RequestParam final char delYn) {
		return boardService.findAllByDelYn(delYn);
	}
	
	/**
     * �Խñ� ������ ��ȸ
     */
    @GetMapping("/boards/{id}")
    public BoardResponseDto findById(@PathVariable final int id) {
        return boardService.findById(id);
    }
    
	/**
	 * �Խñ� ����
	 */
	@PostMapping("/boards")
	public Integer save(@RequestBody final BoardRequestDto params) {
		return boardService.save(params);
	}

	/**
	 * �Խñ� ����
	 */
	@PatchMapping("/boards/{id}")
	public Integer save(@PathVariable final int id, @RequestBody final BoardRequestDto params) {
		return boardService.update(id, params);
	}

	/**
     * �Խñ� ����
     */
    @DeleteMapping("/boards/{id}")
    public Integer delete(@PathVariable final int id) {
        return boardService.delete(id);
    }
}
