package com.spring_boot.projectEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_boot.projectEx.dto.CartDTO;
import com.spring_boot.projectEx.dto.MemberDTO;
import com.spring_boot.projectEx.service.ICartService;
import com.spring_boot.projectEx.service.IOrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {
	
	@Autowired
	ICartService cartService;
	
	@Autowired
	IOrderService ordService;
	
	//주문서 작성 폼 요청
	@PostMapping("/product/orderForm")
	public String orderForm(@RequestParam int[] cartNo,
							@RequestParam int[] cartQty,
							Model model,
							HttpSession session) {
		String memId = (String)session.getAttribute("sid");
		
		//주문하기 버튼 클릭시 변경된 주문수량을 적용하기 위해 cart의 주문수량 변경하는 메소드 호출
		cartService.updateCart(cartNo, cartQty);
		
		//주문서에 출력할 주문자 기본 정보 가져오기
		MemberDTO dto = ordService.getMemberInfo(memId);
		
		//hp 정보
		String[] hp = (dto.getMemHp()).split("-");
		model.addAttribute("memDto", dto);
		model.addAttribute("hp1", hp[0]);
		model.addAttribute("hp2", hp[1]);
		model.addAttribute("hp3", hp[2]);		
		
		//연습문제 1 장바구니 목록 가져오기
		//orderForm.jsp에 필요한 value 표현
		ArrayList<CartDTO> cartList = cartService.cartList(memId);
		model.addAttribute("cartList", cartList);
		
		//연습문제 2 cartList에서 수량변경 하면 구매금액과 총구매금액이 변경되도록 js 추가
		//수량변경 : input text에 직접 변경을 함
		return "product/orderForm";
	}

}
