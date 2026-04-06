package com.spring_mvc.data2;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_mvc.DTO.Product;

@Controller
public class ProductController {

	@RequestMapping("/product/productForm")
	public String productForm() {
		return "product/productForm";
	}

	@RequestMapping("/product/newProduct")
	public String insertProduct(HttpServletRequest request, Model model) {

		String prdNo = request.getParameter("prdNo");
		String prdName = request.getParameter("prdName");
		String prdPrice = request.getParameter("prdPrice");
		String prdCompany = request.getParameter("prdCompany");
		String prdDate = request.getParameter("prdDate");
		String prdStock = request.getParameter("prdStock");

		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);

		return "product/productResult";
	}

	@RequestMapping("/product/productForm2")
	public String productFormView2() {
		return "product/productForm2";
	}

	@RequestMapping("/product/newProduct2")
	public String insertProduct2(@RequestParam("prdNo") String prdNo, @RequestParam("prdName") String prdName,
			@RequestParam("prdPrice") String prdPrice, @RequestParam("prdCompany") String prdMaker,
			@RequestParam("prdDate") String prdDate, @RequestParam("prdStock") String prdStock, Model model) {

		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdMaker);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);

		return "product/productResult2";
	}

	@RequestMapping("product/productForm3")
	public String productFormView3() {
		return "/product/productForm3";
	}

	@RequestMapping("product/newProduct3")
	public String insertProduct3(Product product) {

		System.out.println(product.getPrdNo());
		System.out.println(product.getPrdName());
		System.out.println(product.getPrdPrice());
		System.out.println(product.getPrdMaker());
		System.out.println(product.getPrdDate());
		System.out.println(product.getPrdStock());

		return "/product/productResult3";
	}

	@RequestMapping("product/newProduct4")
	public String insertProduct4(@ModelAttribute("productInfo") Product product) {

		System.out.println(product.getPrdNo());
		System.out.println(product.getPrdName());
		System.out.println(product.getPrdPrice());
		System.out.println(product.getPrdMaker());
		System.out.println(product.getPrdDate());
		System.out.println(product.getPrdStock());

		return "/product/productResult4";
	}

	@RequestMapping("/product/productDetailView/{prdName}")
	public String productDetailView(@PathVariable String prdName) {
		System.out.println(prdName);
		return "index";
	}

	@RequestMapping("/product/productDetailView/{prdName}/{prdCompany}/{prdStock}")
	public String productDetailView1(@PathVariable String prdName, @PathVariable String prdCompany,
			@PathVariable String prdStock) {
		
		System.out.println(prdName);
		System.out.println(prdCompany);
		System.out.println(prdStock);
		return "index";
	}

	// 상품 검색

	@RequestMapping("/product/productSearchForm")
	public String productSearchForm() {
		return "product/productSearchForm";
	}
	
	//HashMap으로 받기
	@RequestMapping("/product/productSearch")
	public String productSearch(@RequestParam HashMap<String, Object> param, Model model) {
		System.out.println(param.get("type"));
		System.out.println(param.get("keyword"));
		//model에 해당하는 dao로 전달해서 DBMS와 쿼리 실행 후 결과값을 전달받는 로직이 필요
		//비즈니스 로직 처리 코드
		Product prd1 = new Product();
		prd1.setPrdNo("001");
		prd1.setPrdName("냉장고");
		prd1.setPrdMaker("엘지");
		
		ArrayList<Product> prdList = new ArrayList<>();
		prdList.add(prd1);
		
		model.addAttribute("prdList", prdList);
		
		return "product/productSearchResult";
	}
	

	/*
	 * @RequestMapping("/product/productSearch") public String
	 * productSearch(@RequestParam HashMap<String, Object> param, Model model) {
	 * 
	 * System.out.println(param.get("type"));
	 * System.out.println(param.get("keyword"));
	 * 
	 * Product prd1 = new Product(); prd1.setPrdNo("1"); prd1.setPrdName("갤럭시");
	 * prd1.setPrdPrice(999900); prd1.setPrdMaker("삼성");
	 * 
	 * Product prd2 = new Product(); prd2.setPrdNo("13"); prd2.setPrdName("갤럭시3");
	 * prd2.setPrdPrice(1099900); prd2.setPrdMaker("삼성");
	 * 
	 * ArrayList<Product> prdList = new ArrayList<>(); prdList.add(prd1);
	 * prdList.add(prd2);
	 * 
	 * // 2) Model 설정 : ArrayList로 데이터 설정 model.addAttribute("prdList", prdList);
	 * 
	 * // 3) studentSearchResult로 결과 출력 return "product/productSearchResult"; }
	 */

}
