package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
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
	
	
	// 새글등록폼
//	@RequestMapping(value ="/board/write" , method = RequestMethod.GET)
	@GetMapping("board/write")
	public String wirteForm(Model model) {
		System.out.println("get write");
		model.addAttribute("boardVO", new BoardVO());
		
		return "board/write";
	}
	
	// 새글등록
//	@RequestMapping(value ="/board/write" , method = RequestMethod.POST)
	@PostMapping("board/write")
	public String write(@Valid @ModelAttribute BoardVO board, BindingResult result) throws Exception {
		System.out.println("post write");
		System.out.println(board);
		if(result.hasErrors()) {
			System.out.println("오류발생");
			return "board/write";
		}
		boardService.addNewBoard(board);
		return "redirect:/board";		
	}
	
	// 게시글 상세조회
	// Query String
//	@GetMapping("/board/detail")
	public String detail(@RequestParam("no") int boardNo, Model model) throws Exception {
//		System.out.println(boardNo);
		BoardVO board = boardService.getBoardByBoardNo(boardNo);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
	@GetMapping("board/{no}")
	public String deatil2(@PathVariable("no") int boardNo, Model model) throws Exception {
		BoardVO board = boardService.getBoardByBoardNo(boardNo);
		model.addAttribute("board", board);
		return "board/detail";
	}
	
}
