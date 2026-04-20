package com.spring_boot_react.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_react.project.dto.ProductVO;
import com.spring_boot_react.project.service.ProductService;

// 추가되는 모든 메소드는 @ResponseBody 처리됨 : RestAPI 구성
@CrossOrigin("*") // 현재 서버가 응답한 페이지의 요청이 아니어도 모두 처리함
@RestController
public class ProductController {

	@Autowired
	ProductService prdService;

	@GetMapping("hello")
	public String hello() {
		return "안녕하세요";
	}

	@GetMapping("product/productList")
	public ArrayList<ProductVO> viewProductList() {
		return prdService.listAllProduct();
	}

	@GetMapping("product/productDetailView/{prdNo}")
	public ProductVO detailViewProduct(@PathVariable String prdNo) {
		return prdService.detailViewProduct(prdNo);
	}

	@PostMapping("/product/insert")
	public void insertProduct(ProductVO prd) {
		prdService.insertProduct(prd);
	}

//	@PostMapping("/product/update")
//	public void updateProduct(ProductVO prd) {
//		prdService.updateProduct(prd);
//	}
//	// axios에서 put으로 요청한 경우1
//	@RequestMapping(value = "/product/update", method = RequestMethod.PUT)
//	public void updateProduct(ProductVO prd) {
//		prdService.updateProduct(prd);
//	}

	// axios에서 put으로 요청한 경우2
	@PutMapping("/product/update")
	public void updateProduct(ProductVO prd) {
		prdService.updateProduct(prd);
	}
	
	//상품정보 삭제
	@GetMapping("/product/delete/{prdNo}")
	public void deleteProduct(@PathVariable String prdNo) {
		prdService.deleteProduct(prdNo);
	}
}
