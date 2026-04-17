package com.spring_boot_jpa_product.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring_boot_jpa_product.project.entity.ProductEntity;

//@Repository : Jpa repo 기능 사용
//@Query : JPQL
//Repo 사용 entity와 기본키 타입을 전달해야 repo 사용 가능
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
	//아무것도 안적어도 기본 CRUD 기능의 메소드 제공

	@Query(value="select p.prdNo from ProductEntity p where p.prdNo =:prdNo")
	String searchById(@Param("prdNo") String prdNo);
}
