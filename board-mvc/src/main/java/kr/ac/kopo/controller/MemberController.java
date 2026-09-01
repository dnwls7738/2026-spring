package kr.ac.kopo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping("/members")
	public String members(Model model) throws Exception {
		List<MemberVO> memberList = memberService.getMemberList();
		model.addAttribute("memberList", memberList);
		return "members/members";
	}
	
}
