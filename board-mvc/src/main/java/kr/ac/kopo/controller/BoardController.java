package kr.ac.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import kra.ac.kopo.board.vo.BoardVO;

@Controller
public class BoardController {
	
	// 전체 게시글 조회 요청
	@RequestMapping("/board")
	public String list(Object model) {
		
		BoardVO board = new BoardVO(1, "제목입니다", "유태웅", "2026-08-26");
		BoardVO board2 = new BoardVO(1, "제목2입니다", "유탱이", "2026-08-26");
		BoardVO board3 = new BoardVO(1, "제목3입니다", "유탱이", "2026-08-26");
		BoardVO board4 = new BoardVO(1, "제목4입니다", "유탱이", "2026-08-26");
		BoardVO[] boardList = new BoardVO[] {board, board2, board3, board4};
		
		model.addAttribute("boardList", boardList);
		
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
