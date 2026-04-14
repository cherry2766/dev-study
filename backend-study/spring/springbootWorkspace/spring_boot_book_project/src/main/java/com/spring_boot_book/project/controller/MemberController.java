package com.spring_boot_book.project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_book.project.service.IMemberService;
import com.spring_boot_book.project.vo.MemberVO;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	IMemberService memService;

	// 로그인 폼
	@GetMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}

	// 회원가입 폼
	@GetMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}

	// 로그인 처리
	@ResponseBody
	@PostMapping("/member/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param, HttpSession session) { 
		String result = memService.loginCheck(param);
		// 로그인 세션 처리
		if (result.equals("success")) {
			session.setAttribute("sid", param.get("id"));
		}
		return result;
	}

	// 로그아웃 처리
	@GetMapping("/member/logout")
	public String userLogout(HttpSession session) {
		session.invalidate(); 
		return "redirect:/";
	}

	// id 중복 체크 요청 처리
	@ResponseBody
	@PostMapping("/member/idCheck")
	public int idCheck(@RequestParam String id) {
		String id_res = memService.idCheck(id);

		int result = 0;
		if (id_res != null) { 
			result = 1;
		}
		return result;
	}
	
	@PostMapping("/member/join")
	public String join(MemberVO vo, @RequestParam("memHp1") String memHp1, @RequestParam("memHp2") String memHp2,
			@RequestParam("memHp3") String memHp3) {
		String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
		vo.setMemHp(memHp);
		memService.insertMember(vo); 
		return "redirect:/member/loginForm";
	}

}
