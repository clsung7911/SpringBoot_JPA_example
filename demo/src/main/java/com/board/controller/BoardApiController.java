package com.board.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	 * �Խñ� ����
	 */
	@PostMapping("/boards")
	public Integer save(@RequestBody final BoardRequestDto params) {
		return boardService.save(params);
	}

	/**
	 * �Խñ� ����Ʈ ��ȸ
	 */
	@GetMapping("/boards")
	public List<BoardResponseDto> findAll() {
		return boardService.findAll();
	}

	/**
	 * �Խñ� ����
	 */
	@PatchMapping("/boards/{id}")
	public Integer save(@PathVariable final int id, @RequestBody final BoardRequestDto params) {
		return boardService.update(id, params);
	}

//	@GetMapping("/test")
//	public String main() {
//		throw new CustomException(ErrorCode.POSTS_NOT_FOUND);
//	}
}
