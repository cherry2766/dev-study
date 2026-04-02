package com.spring_mvc.data;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewController {
	
	//http://localhost:8080/data/ 요청을 처리하는 메소드
	@RequestMapping("/")
	public String index() {
		return "index"; //view 페이지명을 결정하는 문자열 => /webapp/WEB-INF/views/index.jsp
	}
	
	//http://localhost:8080/data/showInfo 요청을 처리하는 메소드
	//web 요청 처리하는 메소드는 web과 관련 객체를 파라미터 통해 주입받을 수 있음
	//Model 객체 : 메소드 처리 결과를 view로 전달할 때 많이 사용
	@RequestMapping("/showInfo")
	public String showInfo(Model model) {
		model.addAttribute("name", "홍길동");
		model.addAttribute("age", "30");
		return "showInfo"; //showInfo.jsp
	}
	
	//ModelAndView 객체에 view로 전달한 attribute 포함
	//View 페이지도 객체를 통해 전달
	@RequestMapping("/showInfo2")
	public ModelAndView showInfoMV(ModelAndView mv) {
		
		mv.addObject("name", "이몽룡");
		mv.addObject("address", "서울");
		mv.setViewName("showInfoMV");
		
		return mv;
	}

}
