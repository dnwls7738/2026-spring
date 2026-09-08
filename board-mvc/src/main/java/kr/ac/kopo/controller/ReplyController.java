package kr.ac.kopo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.reply.service.ReplyService;
import kr.ac.kopo.reply.vo.ReplyVO;

/**
 * 댓글 요청 서비스(비동기통신)
 */

@RestController
public class ReplyController {
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/reply/{boardNo}")
	public void addReply(ReplyVO reply) {

		replyService.addReplyService(reply);
	}
	
	
	@GetMapping("/reply/{boardNo}")
	public List<ReplyVO> getReplyList(@PathVariable("boardNo") int boardNo) {
		List<ReplyVO> replyList = replyService.getReplyListService(boardNo);
		for(ReplyVO reply : replyList) {
			System.out.println(reply);
		}
		System.out.println();
		return replyList;
	}
}
