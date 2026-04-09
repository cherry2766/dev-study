package com.spring_mvc.mybatisEx.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_mvc.mybatisEx.service.IBookService;
import com.spring_mvc.mybatisEx.vo.BookVO;

@RestController
public class BookRestController {
	
	private final IBookService service;

	public BookRestController(IBookService service) {
		this.service = service;
	}
	
	@RequestMapping("/book/bookSearch1")
	public ArrayList<BookVO> bookSearch1(@RequestParam HashMap<String, Object> param, Model model) {
		ArrayList<BookVO> bookList = service.bookSearch(param);
		model.addAttribute("bookList", bookList);
		return bookList;
	}

	@RequestMapping("/book/bookSearch3")
	public ArrayList<BookVO> bookSearch3(@RequestParam HashMap<String, Object> param, Model model) {
		ArrayList<BookVO> bookList = service.bookSearch(param);
		model.addAttribute("bookList", bookList);
		return bookList;
	}
	
	@RequestMapping("/book/bookNoCheck/{bookNo}")
	public String bookNoCheck(@PathVariable String bookNo) {
		String res = service.bookNoCheck(bookNo);
		return res;
	}

	@RequestMapping("/book/bookNoCheck1")
	public String bookNoCheck1(@RequestParam String bookNo) {
		String res = service.bookNoCheck(bookNo);
		return res;
	}

	@RequestMapping("/book/bookNoCheck2/{bookNo}")
	public String bookNoCheck2(@PathVariable String bookNo) {
		String res = service.bookNoCheck(bookNo);
		return res;
	}

	@RequestMapping("/book/bookNoCheck3")
	public String bookNoCheck3(@RequestBody String bookNo) {
		String res = service.bookNoCheck(bookNo);
		return res;
	}

	@RequestMapping("/book/bookNoCheck4/{bookNo}")
	public String bookNoCheck4(@PathVariable String bookNo) {
		String res = service.bookNoCheck(bookNo);
		return res;
	}

	@RequestMapping("/book/bookNoCheck5")
	public String bookNoCheck3(@RequestBody HashMap<String, String> map) {
		String bookNo = map.get("bookNo");
		String res = service.bookNoCheck(bookNo);
		return res;
	}
} 
