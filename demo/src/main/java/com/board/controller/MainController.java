package com.board.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.dto.UserRequestDto;
import com.board.model.BoardService;
import com.board.model.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final UserService userService;

	/**
	 * �α��� �������� �̵�
	 * @return
	 */
	@GetMapping("/")
	public String main() {
		return "login/login";
	}
	
	/**
	 * ȸ������ ������ �̵�
	 */
	@GetMapping("/join")
	public String joinForm() {
		return "login/join";
	}
	/**
	 * ȸ������
	 * @param value
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/join")
	public Map<String, Object> join(@RequestBody final UserRequestDto user){
		Map<String, Object> response = new HashMap<>();
		
		if(userService.findById(user.getUserId()).isPresent()) {
			response.put("duplicate", true);
			return response;
		}
		
		response.put("success", userService.join(user) != null ? true : false);
		return response;
	}
	/**
	 * �α��� �� ����Ʈ�� �̵�
	 * @param value
	 * @return
	 */
	@ResponseBody
	@PostMapping(value = "/login")
	public String loginList(@RequestBody final UserRequestDto user){
		return "/board/list";
	}
}
