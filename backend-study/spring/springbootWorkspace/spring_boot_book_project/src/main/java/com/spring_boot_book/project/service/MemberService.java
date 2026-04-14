package com.spring_boot_book.project.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring_boot_book.project.model.IMemberDAO;
import com.spring_boot_book.project.vo.MemberVO;

@Service
@Primary
public class MemberService implements IMemberService{
	@Autowired
	IMemberDAO dao;
	//WebsecurityConfig에서 bean 등록함
	@Autowired
	PasswordEncoder pwdEncoder;
	
	@Override
	public String loginCheck(HashMap<String, Object> map) {
		String encodedPwd = dao.loginCheck((String)map.get("id"));
		String result = "fail";
		String memPwd = (String)map.get("pwd");
		if(encodedPwd != null && pwdEncoder.matches(memPwd, encodedPwd)) {
			result = "success";
		}
		return result;
	}

	@Override
	public void insertMember(MemberVO vo) {
		//비밀번호 필드값만 추출해서 암호화
		String encodedPwd = pwdEncoder.encode(vo.getMemPwd());
		vo.setMemPwd(encodedPwd);
		
		dao.insertMember(vo);
	}

	@Override
	public String idCheck(String id) {
		return dao.idCheck(id);
	}	
	
}
