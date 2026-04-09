package com.spring_mvc.mybatisEx.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.spring_mvc.mybatisEx.vo.BookVO;

public interface IBookService {
	
	ArrayList<BookVO> listAllBook();
	void insertBook(BookVO bookVo); 
	void updateBook(BookVO bookVo); 
	void deleteBook(String bookNo); 
	BookVO detailViewBook(String bookNo);
	String bookNoCheck(String bookNo);
	ArrayList<BookVO> bookSearch(HashMap<String, Object> map);
}
