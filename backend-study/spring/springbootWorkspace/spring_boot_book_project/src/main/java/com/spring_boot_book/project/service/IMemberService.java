package com.spring_boot_book.project.service;

import java.util.HashMap;

import com.spring_boot_book.project.vo.MemberVO;

public interface IMemberService {
	public String loginCheck(HashMap<String, Object> map);
	public String idCheck(String id);
	public void insertMember(MemberVO vo);
}
