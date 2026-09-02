package kr.ac.kopo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//회원 전체 목록 불러오기
	@RequestMapping("/members")
	public String members(Model model) throws Exception {
		List<MemberVO> memberList = memberService.getMemberList();
		model.addAttribute("memberList", memberList);
		return "members/members";
	}
	
	// 회원가입 폼
	@RequestMapping(value ="/members/sign" , method = RequestMethod.GET)
	@GetMapping("members/sign")
	public String wirteForm(Model model) {
		System.out.println("get write");
		model.addAttribute("memberVO", new MemberVO());
		
		return "members/sign";
	}
	
	// 회원가입
	@RequestMapping(value ="/members/sign" , method = RequestMethod.POST)
	@PostMapping("members/sign")
	public String write(@Valid @ModelAttribute MemberVO member, BindingResult result) throws Exception {
		System.out.println("post write");
		System.out.println(member);
		if(result.hasErrors()) {
			System.out.println("오류발생");
			return "members/sign";
		}
		memberService.addNewMember(member);
		return "redirect:/members";		
	}
	
	@GetMapping("members/mypage/{id}")
	public String mypage(@PathVariable("id") String memberId, Model model) throws Exception{
		MemberVO member = memberService.getMemberById(memberId);
		model.addAttribute("member", member);
		return "members/mypage";
	}
}
