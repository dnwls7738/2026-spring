package kr.ac.kopo.reply.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.kopo.mapper.ReplyMapper;
import kr.ac.kopo.reply.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO{
	
	private ReplyMapper replymapper;
	
	public ReplyDAOImpl(ReplyMapper replymapper) {
		super();
		this.replymapper = replymapper;
	}

	@Override
	public void save(ReplyVO reply) {
		
		replymapper.save(reply);
	}

	@Override
	public List<ReplyVO> selectByReplyBoardNo(int boardNo) {
	
		return replymapper.selectByBoardNo(boardNo);
	}




}
