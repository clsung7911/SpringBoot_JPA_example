package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

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
	public String join() {
		return "login/join";
	}
}
