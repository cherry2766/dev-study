package com.spring_mvc.project;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//bean 등록
//controller는 frontController로 부터 요청 처리를 전달받아 처리 후 view 정보를 frontController에게 반환
@Controller
public class HomeController {
	
	//로그 기록 객체
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	// /project/로 요청이 들어오면
	//@RequestMapping(value = "/", method = RequestMethod.GET)
	
	@RequestMapping(value = "/jsp/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//log 기록 : 파라미터로 주입된 locale 정보(클라이언트 위치정보)를 로그로 기록
		logger.info("Welcome home! The client locale is {}.", locale); //콘솔로그 기록
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); //view로 포워딩될 때 같이 전달
		
		return "jsp/home"; //view 결정 /WEB-INF/views/jsp/home.jsp
		//return "home"; //포워딩할 view 결정 후 -> 프론트 컨트롤러에게 전달(model 객체 포함해서)
		//프론트컨트롤러 -> view결정 -> views 폴더 안에 home.jsp로 포워딩
	}
	
}
