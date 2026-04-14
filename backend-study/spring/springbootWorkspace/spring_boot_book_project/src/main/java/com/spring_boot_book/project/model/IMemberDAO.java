package com.spring_boot_book.project.model;

import com.spring_boot_book.project.vo.MemberVO;

public interface IMemberDAO {
	
	public String loginCheck(String id);	//id로 검색 후 pwd 반환
	public String idCheck(String id);
	public void insertMember(MemberVO vo);
}
