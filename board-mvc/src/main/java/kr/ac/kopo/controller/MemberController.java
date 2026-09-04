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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import kr.ac.kopo.board.vo.BoardVO;
import kr.ac.kopo.member.service.MemberService;
import kr.ac.kopo.member.vo.MemberVO;
import oracle.jdbc.proxy.annotation.Post;

@SessionAttributes(value = {"userVO"})
@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;

	// 회원 전체 목록 불러오기
	@RequestMapping("/members")
	public String members(Model model) throws Exception {
		List<MemberVO> memberList = memberService.getMemberList();
		model.addAttribute("memberList", memberList);
		return "members/members";
	}

	// 회원가입 폼
	@RequestMapping(value = "/members/sign", method = RequestMethod.GET)
	@GetMapping("/members/sign")
	public String wirteForm(Model model) {
		System.out.println("get write");
		model.addAttribute("memberVO", new MemberVO());

		return "members/sign";
	}

	// 회원가입
	@RequestMapping(value = "/members/sign", method = RequestMethod.POST)
	@PostMapping("/members/sign")
	public String write(@Valid @ModelAttribute MemberVO member, BindingResult result) throws Exception {
		System.out.println("post write");
		System.out.println(member);
		if (result.hasErrors()) {
			System.out.println("오류발생");
			return "members/sign";
		}
		memberService.addNewMember(member);
		return "redirect:/";
	}

	// 마이페이지
	@GetMapping("/members/mypage/{id}")
	public String mypage(@PathVariable("id") String memberId, Model model) throws Exception {
		MemberVO member = memberService.getMemberById(memberId);
		model.addAttribute("member", member);
		return "members/mypage";
	}

	// 로그인폼
	@GetMapping("/login")
	public String login() {

		return "members/login";
	}
	
	// 로그인
	@PostMapping("/login")
	public String login(MemberVO member, Model model) {
		MemberVO user = memberService.checkMember(member);
		System.out.println(user);
		if(user == null) {
			// 로그인 실패
			model.addAttribute("msg", "아이디 혹은 비밀번호가 맞지않습니다.");
			return "members/login";
		}
			// 로그인 성공
		model.addAttribute("userVO", user);

		return "redirect:/";
	}
	
	// 로그아웃
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		status.setComplete();
		return "redirect:/";
	}

//	// 로그인
//	@PostMapping("/login")
//	public String login(MemberVO member, Model model, HttpSession session) {
//		MemberVO user = memberService.checkMember(member);
//		System.out.println(user);
//		if(user == null) {
//			// 로그인 실패
//			model.addAttribute("msg", "아이디 혹은 비밀번호가 맞지않습니다.");
//			return "members/login";
//		}
//			// 로그인 성공
//		session.setAttribute("userVO", user);
//
//		return "redirect:/";
//	}
//	
//	// 로그아웃
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {

//		session.invalidate();
//		return "redirect:/";
//	}
}
