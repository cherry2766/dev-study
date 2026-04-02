package com.spring_mvc.second;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewController {
	
	
	private static final Logger log = LoggerFactory.getLogger(NewController.class);
	
	//http://localhost:8080/second/ 요청을 처리하는 메서드
	@GetMapping("/")
	public String index(Locale locale, Model model) {
		log.info("hello index! The client locale is {}", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	//http://localhost:8080/second/newView 요청을 처리하는 메서드
	@GetMapping("/newView")
	public String newView2() {
		return "newView";
	}

}
