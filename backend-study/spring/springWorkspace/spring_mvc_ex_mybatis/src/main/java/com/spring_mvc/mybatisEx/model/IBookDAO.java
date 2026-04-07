package com.spring_mvc.mybatisEx.model;

import java.util.ArrayList;

import com.spring_mvc.mybatisEx.vo.BookVO;


public interface IBookDAO {
	
	ArrayList<BookVO> listAllBook();
	void insertBook(BookVO bookVo); 
	void updateBook(BookVO bookVo); 
	void deleteBook(String bookNo); 
	BookVO detailViewBook(String bookNo);
}
