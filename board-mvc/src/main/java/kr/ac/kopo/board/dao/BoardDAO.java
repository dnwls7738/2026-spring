package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

/**
 * 게시판 CRUD를 위한 DAO 클래스
 */
public interface BoardDAO {
	/**
	 * 전체게시글 조회
	 */
	List<BoardVO> selectAll();
	
	
	
}
