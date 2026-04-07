package com.spring_mvc.mybatis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_mvc.mybatis.model.IProductDAO;
import com.spring_mvc.mybatis.vo.ProductVO;

@Service
public class ProductService implements IProductService {
	//dao 객체 주입(인터페이스 객체 주입)
	
	@Autowired
	@Qualifier("IProductDAO")
	IProductDAO dao;
	
	@Override
	public ArrayList<ProductVO> listAllProduct() {
		//dao의 관련 메소드 호출
		return dao.listAllProduct();
	}

	@Override
	public void insertProduct(ProductVO prdVo) {
		dao.insertProduct(prdVo);
		
	}

	@Override
	public void updateProduct(ProductVO prdVo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(String prdNo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductVO detailViewProduct(String prdNo) {
		return dao.detailViewProduct(prdNo);
	}
	
}
