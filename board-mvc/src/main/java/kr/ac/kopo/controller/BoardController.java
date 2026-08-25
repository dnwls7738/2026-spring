package kr.ac.kopo.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	@RequestMapping("/board")
	public String list() {
		return "board/list";
	}
	
	@RequestMapping("/board/detail")
	public String detail() {
		return "board/detail";
	}
	
	@RequestMapping("/board/new")
	public String newbaord() {
		return "board/new";
	}
	
}
