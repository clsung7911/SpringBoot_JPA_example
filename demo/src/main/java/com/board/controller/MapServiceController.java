package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapServiceController {
	 
    /**
     * �������� �̵�
     * @return
     */
    @GetMapping("/main")
    public String openMapService() {
    	return "/map/mapMain";
    }
}
