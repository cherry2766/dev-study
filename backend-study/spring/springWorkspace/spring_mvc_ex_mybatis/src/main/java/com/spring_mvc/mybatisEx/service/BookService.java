package com.spring_mvc.mybatisEx.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.spring_mvc.mybatisEx.model.IBookDAO;
import com.spring_mvc.mybatisEx.vo.BookVO;

@Service
public class BookService implements IBookService{
	
	private final IBookDAO dao;
	
	public BookService(IBookDAO dao) {
        this.dao = dao;
    }

	@Override
	public ArrayList<BookVO> listAllBook() {
		
		return dao.listAllBook();
	}

	@Override
	public void insertBook(BookVO bookVo) {
		dao.insertBook(bookVo);
		
	}

	@Override
	public void updateBook(BookVO bookVo) {
		dao.updateBook(bookVo);
		
	}

	@Override
	public void deleteBook(String bookNo) {
		dao.deleteBook(bookNo);
		
	}

	@Override
	public BookVO detailViewBook(String bookNo) {
		return dao.detailViewBook(bookNo);
	}

	
	
	
	
}
