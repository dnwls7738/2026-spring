package kr.ac.kopo.member.dao;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {
	
	List<MemberVO> selectAll();
	
	void insert(MemberVO member);
}
