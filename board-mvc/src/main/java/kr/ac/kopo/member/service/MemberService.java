package kr.ac.kopo.member.service;

import java.util.List;

import kr.ac.kopo.member.vo.MemberVO;


public interface MemberService {
	
	List<MemberVO> getMemberList() throws Exception;

}
