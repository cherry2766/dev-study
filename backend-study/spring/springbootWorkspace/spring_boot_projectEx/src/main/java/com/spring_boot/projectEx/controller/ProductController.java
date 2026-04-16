package com.spring_boot.projectEx.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_boot.projectEx.dto.ProductDTO;
import com.spring_boot.projectEx.service.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	IProductService prdService;
	
	@GetMapping("/product/productListCtg/{ctgId}")
	public String productCtgList(@PathVariable String ctgId, Model model) {
		ArrayList<ProductDTO> prdList = prdService.listCtgProduct(ctgId);
		model.addAttribute("prdList", prdList);
		return "product/productCtgListView";
	}
	
	@GetMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo, Model model) {
		ProductDTO prd = prdService.detailViewProduct(prdNo);
		model.addAttribute("prd",prd);
		return "product/productDetailView";
	}
	
	// 상품 관리 페이지
	@GetMapping("/product/adminPage")
	public String adminPage(Model model) {
	    // 전체 상품 목록 가져오기 (기존 메서드 재사용)
	    ArrayList<ProductDTO> prdList = prdService.getAllProducts();
	    model.addAttribute("prdList", prdList);
	    return "product/adminPage";
	}
	
	// 상품 등록 폼
	@GetMapping("/product/insertForm")
	public String insertForm() {
	    return "product/insertForm";
	}

	// 상품 등록 처리
	@PostMapping("/product/insert")
	public String insert(ProductDTO dto) {
		prdService.insertProduct(dto);
	    return "redirect:/product/adminPage";
	}
	
	// 상품 수정 폼 (상품번호로 기존 정보 불러오기)
	@GetMapping("/product/editProductForm")
	public String editProductForm(@RequestParam String prdNo, Model model) {
	    ProductDTO dto = prdService.detailViewProduct(prdNo);
	    model.addAttribute("prd", dto);
	    return "product/editProductForm";
	}

	// 상품 수정 처리
	@PostMapping("/product/editProduct")
	public String editProduct(ProductDTO dto) {
		prdService.updateProduct(dto);
	    return "redirect:/product/adminPage";
	}
	
	// 상품 삭제 처리
	@GetMapping("/product/deleteProduct")
	public String deleteProduct(@RequestParam String prdNo) {
		prdService.deleteProduct(prdNo);
	    return "redirect:/product/adminPage";
	}
}
