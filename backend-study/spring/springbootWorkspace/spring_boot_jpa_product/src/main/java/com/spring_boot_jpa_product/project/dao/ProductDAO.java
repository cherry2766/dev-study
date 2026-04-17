package com.spring_boot_jpa_product.project.dao;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_product.project.entity.ProductEntity;
import com.spring_boot_jpa_product.project.repository.ProductRepository;

@Service
@Primary
public class ProductDAO implements IProductDAO {
	@Autowired
	ProductRepository prdRepo;

	@Override
	public ArrayList<ProductEntity> listAllProduct() {
		// 프로덕트 테이블의 모든 레코드 select 후 반환(jpa가 제공하는 모듈 이용-repository 메서드)
		// findAll() : List 타입을 반환 -> 형변환 필요
		return (ArrayList<ProductEntity>)prdRepo.findAll();
	}

	@Override
	public void insertProduct(ProductEntity entity) {
		//id로 등록된 필드 값이 동일하면 update/ id 필드값이 없으면 insert
		prdRepo.save(entity);		
	}

	@Override
	public void updateProduct(ProductEntity entity) {
		prdRepo.save(entity);
	}

	@Override
	public void deleteProduct(String prdNo) {
		prdRepo.deleteById(prdNo);	
	}

	@Override
	public Optional<ProductEntity> detailViewProduct(String prdNo) {
		//entity에서 @Id 필드를 적용시켜놓은 필드로 조건 검색
		return prdRepo.findById(prdNo); //select * from product where prdNo = #{prdNo}
	}

	@Override
	public String prdNoCheck(String prdNo) {
		return prdRepo.searchById(prdNo);
	}
	
	
}
