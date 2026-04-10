package com.spring_boot_mybatis_ex.project;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("msg", "안녕하세요!");
		return "hello";
	}

}
