package kr.ac.kopo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardMapper {
	
	@Select(""" 
			select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as regDate from tbl_board order by no desc 
			""")
	List<BoardVO> selectAll();
	
	@Select("""
			select no, title,writer, content, view_cnt as vierCnt, to_char(reg_date, 'yyyy-mm-dd') as regDate from  tbl_board where no=#{no}
			""")
	BoardVO selectByNo(int boardNo); 
	
	// xml
	void insert(BoardVO board);
}
