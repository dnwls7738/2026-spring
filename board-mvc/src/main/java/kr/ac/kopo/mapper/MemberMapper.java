package kr.ac.kopo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberMapper {
	
	@Select(""" 
			select id, name, password from tbl_member order by reg_date desc 
			""")
	List<MemberVO> selectAll();
	
	@Select("""
			select id, name, password, email_id as emailId, email_domain as emailDomain, tel1, tel2, tel3, post, basic_addr as basicAddr, detail_addr as detailAddr, type, to_char(reg_date, 'yyyy-mm-dd') as regDate from tbl_member where id=#{id}
			""")
	MemberVO selectById(String memberId); 
	
	// xml
	void insert(MemberVO member);

	@Select("""
			select * from tbl_member where id = #{id} and password = #{password}
			""")
	MemberVO login(MemberVO loginVO);
	
}
