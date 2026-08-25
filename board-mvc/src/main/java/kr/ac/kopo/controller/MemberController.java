package kr.ac.kopo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@RequestMapping("/members")
	public String members() {
		return "members/members";
	}
	
	@RequestMapping("/members/hong")
	public String mypage() {
		return "members/mypage";
	}

}
