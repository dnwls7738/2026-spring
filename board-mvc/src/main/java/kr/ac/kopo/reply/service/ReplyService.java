package kr.ac.kopo.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.reply.dao.ReplyDAO;
import kr.ac.kopo.reply.vo.ReplyVO;

@Service
public class ReplyService {
	
	@Autowired
	private ReplyDAO replyDao;
	
	public void addReplyService(ReplyVO reply) {
		replyDao.save(reply);
	}
	
	public List<ReplyVO> getReplyListService(int boardNo){
		return replyDao.selectByReplyBoardNo(boardNo);
	}
}
