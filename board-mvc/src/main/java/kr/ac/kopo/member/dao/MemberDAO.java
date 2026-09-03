package kr.ac.kopo.member.dao;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;

public interface MemberDAO {
	
	//회원 전체 정보
	List<MemberVO> selectAll();
	
	//회원 가입
	void insert(MemberVO member);
	
	//마이페이지
	MemberVO selectById(String memberId);
	
	//로그인
	MemberVO login(MemberVO loginVO);
}
