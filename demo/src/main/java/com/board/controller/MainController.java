package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	/**
	 * 로그인 페이지로 이동
	 * @return
	 */
	@GetMapping("/")
	public String main() {
		return "login/login";
	}
	
	/**
	 * 회원가입 페이지 이동
	 */
	@GetMapping("/join")
	public String join() {
		return "login/join";
	}
}
