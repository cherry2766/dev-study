package com.spring_boot.projectEx.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.service.IMemberService;
import com.spring_boot.projectEx.service.MemberService;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {

	@Autowired
	IMemberService memService;
	
	//myPage
	@GetMapping("/member/myPage")
	public String myPage() {
		return "member/myPage";
	}
	
	//본인 정보 확인
	@GetMapping("/member/myInfo")
	public String myInfo(HttpSession session, Model model) {
		String memId = (String)session.getAttribute("sid");
		MemberDTO dto = memService.getMemberInfo(memId);
		model.addAttribute("memDto", dto);
		return "member/myInfo";
	}
	
	//회원정보 수정 폼
	@GetMapping("/member/editForm")
	public String editForm(HttpSession session, Model model) {
		String memId = (String) session.getAttribute("sid");
		MemberDTO dto = memService.getMemberInfo(memId);
		
		String[] hp = dto.getMemHp().split("-");
	    model.addAttribute("memDto", dto);
	    model.addAttribute("hp1", hp[0]);
	    model.addAttribute("hp2", hp[1]);
	    model.addAttribute("hp3", hp[2]);
	    
	    return "member/editForm";
	}
	
	// 회원정보 수정 처리
	@PostMapping("/member/edit")
	public String edit(MemberDTO dto,
	                   @RequestParam String memHp1,
	                   @RequestParam String memHp2,
	                   @RequestParam String memHp3,
	                   HttpSession session) {
	    String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
	    dto.setMemHp(memHp);
	    dto.setMemId((String) session.getAttribute("sid"));
	    
	    memService.updateMember(dto);
	    return "redirect:/member/myInfo";
	}
	
	// 회원 탈퇴 폼
	@GetMapping("/member/deleteForm")
	public String deleteForm() {
	    return "member/deleteForm";
	}
	
	// 회원 탈퇴 처리
	@PostMapping("/member/delete")
	public String delete(@RequestParam String memPwd,
	                     HttpSession session) {
	    String memId = (String) session.getAttribute("sid");
	    
	    int result = memService.deleteMember(memId, memPwd);
	    
	    if (result == 1) {          // 비밀번호 일치 → 탈퇴 성공
	        session.invalidate();   // 세션 삭제
	        return "redirect:/";
	    } else {                    // 비밀번호 불일치
	        return "redirect:/member/deleteForm?error=true";
	    }
	}

	// 로그인 폼
	@GetMapping("/member/loginForm")
	public String loginForm() {
		return "member/loginForm";
	}

	/*
	 * //로그인 처리
	 * 
	 * @ResponseBody
	 * 
	 * @PostMapping("/member/login") public String loginCheck(@RequestParam
	 * HashMap<String, Object> param, HttpSession session) { //현재 요청 클라이언트의 session이
	 * 전달 String memId = memService.loginCheck(param); String result = "fail"; //로그인
	 * 세션 처리 if(memId != null) { session.setAttribute("sid", memId);
	 * result="success"; } return result; }
	 */

	// 로그인 처리
	@ResponseBody
	@PostMapping("/member/login")
	public String loginCheck(@RequestParam HashMap<String, Object> param, HttpSession session) { // 현재 요청 클라이언트의
																									// session이 전달
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
		session.invalidate(); // 요청 클라이언트의 세션을 지움(로그인 유지 안됨)
		return "redirect:/";
	}

	// 회원가입 폼 요청 처리
	@GetMapping("/member/joinForm")
	public String joinForm() {
		return "member/joinForm";
	}

	// id 중복 체크 요청 처리
	@ResponseBody
	@PostMapping("/member/idCheck")
	public int idCheck(@RequestParam String id) {
		String id_res = memService.idCheck(id);

		int result = 0;
		if (id_res != null) { // 기존 id가 있음
			result = 1;
		}
		return result;
	}

	@PostMapping("/member/join")
	public String join(MemberDTO dto, @RequestParam("memHp1") String memHp1, @RequestParam("memHp2") String memHp2,
			@RequestParam("memHp3") String memHp3) {
		String memHp = memHp1 + "-" + memHp2 + "-" + memHp3;
		dto.setMemHp(memHp);
		memService.insertMember(dto); // 회원가입 완료 후 오류가 없으면
		return "redirect:/member/loginForm";
	}
}
