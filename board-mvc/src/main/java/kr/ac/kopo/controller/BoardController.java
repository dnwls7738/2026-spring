package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.board.service.BoardService;
import kr.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
//	 전체 게시글 조회 요청
	@RequestMapping("/board")
	public String list(Model model) throws Exception {
		List<BoardVO> boardList = boardService.getBoardList();
		model.addAttribute("boardList",boardList);
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
	
	@GetMapping("board/write")
	public void wirteForm() {
		System.out.println("get write");
	}
	
	@PostMapping("board/write")
	public void write() {
		System.out.println("post write");
	}
	
}
