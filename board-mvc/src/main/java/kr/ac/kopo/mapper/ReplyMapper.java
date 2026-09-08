package kr.ac.kopo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import kr.ac.kopo.reply.vo.ReplyVO;

public interface ReplyMapper {

	@Insert ("""
				insert into tbl_reply(no, board_no, writer, content)
				values(seq_tbl_reply_no.nextval, #{boardNo}, #{writer}, #{content})
			""")
	void save(ReplyVO reply);
	
	
	@Select("""
				select no, content, writer, to_char(reg_date, 'yyyy-mm-dd hh:mi:ss') as regDate
				from tbl_reply
				where board_no = #{boardNo}
				order by no desc
			""")
	List<ReplyVO> selectByBoardNo(int boardNo);
}
