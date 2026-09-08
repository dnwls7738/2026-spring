package kr.ac.kopo.reply.dao;

import java.util.List;

import kr.ac.kopo.reply.vo.ReplyVO;

public interface ReplyDAO {
	void save(ReplyVO reply);
	List<ReplyVO> selectByReplyBoardNo(int boardNo);
}
