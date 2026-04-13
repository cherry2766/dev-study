package com.spring_boot.projectEx.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.model.IMemberDAO;

@Service
public class MemberService implements IMemberService{
	@Autowired
	IMemberDAO dao;

	@Override
	public String loginCheck(HashMap<String, Object> map) {
		//dao에서 전달되는 memId 여부에 따라 result 결정
		String memId = dao.loginCheck(map);
//		String result = "fail";
//		if(memId != null) {
//			result="success";
//		}
		return memId;
	}

	@Override
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String idCheck(String id) {
		return dao.idCheck(id);
	}
	
	
	
}
