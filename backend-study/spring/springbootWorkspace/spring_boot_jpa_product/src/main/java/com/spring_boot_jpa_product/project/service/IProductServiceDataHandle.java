package com.spring_boot_jpa_product.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import com.spring_boot_jpa_product.project.dto.ProductDTO;
import com.spring_boot_jpa_product.project.entity.ProductEntity;


public interface IProductServiceDataHandle {
	//데이터교환 Entity
	ArrayList<ProductEntity> listAllProduct();    //전체 상품 조회 - null이 반환되지 않음
	void insertProduct(ProductEntity entity);      //상품 정보 등록
	void updateProduct(ProductEntity entity);      //상품 정보 수정
	void deleteProduct(String prdNo);         //상품 정보 삭제
	Optional<ProductEntity> detailViewProduct(String prdNo);//상세 상품 조회 
	//entity 반환되어야 하는데 null이 반환될 가능성이 있고 실제 null이 반환되었을 때 오류남
	String prdNoCheck(String prdNo);		  //상품번호 중복 확인
	
	//jpa에서 1개 entity 조회하는 메소드는 반환타입이 Optional<ProductEntity> 로 되어있음
	//dao나 repo 관련 service에서도 반환타입 맞춰 사용해야 함
	
	ArrayList<ProductEntity> productSearch(HashMap<String, String> param); //상품 검색
}
