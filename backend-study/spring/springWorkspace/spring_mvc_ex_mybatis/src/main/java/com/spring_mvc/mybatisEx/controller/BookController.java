package com.spring_mvc.mybatisEx.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_mvc.mybatisEx.service.IBookService;
import com.spring_mvc.mybatisEx.vo.BookVO;

@Controller
public class BookController {

	private final IBookService service;

	public BookController(IBookService service) {
		this.service = service;
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/book/listAllBook")
	public String listAllBook(Model model) {
		ArrayList<BookVO> bookList = service.listAllBook();
		model.addAttribute("bookList", bookList);
		return "book/bookListView";
	}

	@RequestMapping("/book/detailViewBook/{bookNo}")
	public String detailViewBook(@PathVariable String bookNo, Model model) {
		BookVO book = service.detailViewBook(bookNo);
		model.addAttribute("book", book);
		return "book/bookDetailView";
	}

	@RequestMapping("/book/newBookForm")
	public String viewBookForm() {
		return "book/newBookForm";
	}

	@RequestMapping("/book/insertBook")
	public String insertBook(BookVO vo) {
		service.insertBook(vo);
		return "redirect:/book/listAllBook";
	}

	@RequestMapping("/book/updateBookForm/{bookNo}")
	public String viewUpdateForm(@PathVariable String bookNo, Model model) {
		BookVO book = service.detailViewBook(bookNo);
		model.addAttribute("book", book);
		return "book/updateBookForm";
	}

	@RequestMapping("/book/updateBook")
	public String updateBook(BookVO book) {
		service.updateBook(book);
		return "redirect:/book/listAllBook";
	}

	@RequestMapping("/book/deleteBook/{bookNo}")
	public String deleteBook(@PathVariable String bookNo) {
		service.deleteBook(bookNo);
		return "redirect:/book/listAllBook";
	}

	@RequestMapping("/book/bookSearchForm1")
	public String viewSearchForm1() {
		return "book/bookSearchForm1";
	}

	@RequestMapping("/book/bookSearchForm2")
	public String viewSearchForm2() {
		return "book/bookSearchForm2";
	}
	
	@RequestMapping("/book/bookSearchForm3")
	public String viewSearchForm3() {
		return "book/bookSearchForm3";
	}

	@RequestMapping("/book/bookSearch2")
	public String bookSearch2(@RequestParam HashMap<String, Object> param, Model model) {
		ArrayList<BookVO> bookList = service.bookSearch(param);
		model.addAttribute("bookList", bookList);
		return "book/bookSearchResultView";
	}

}
