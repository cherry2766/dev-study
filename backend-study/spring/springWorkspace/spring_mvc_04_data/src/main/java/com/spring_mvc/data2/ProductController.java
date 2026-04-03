package com.spring_mvc.data2;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.DTO.Product;

@Controller
public class ProductController {
	
	@RequestMapping("/product/productForm")
	public String productFormView() {
		return "product/productForm";
	}
	
	@RequestMapping("/product/productForm2")
	public String productFormView2() {
		return "product/productForm2";
	}
	
	@RequestMapping("/product/productForm3")
	public String productFormView3() {
		return "product/productForm3";
	}
	
	@RequestMapping("/product/productForm4")
	public String productFormView4() {
		return "product/productForm4";
	}
	
	@RequestMapping("/product/newProduct")
	public String createProduct(HttpServletRequest request, Model model) {
		String prdNo = request.getParameter("prdNo");
		String prdName = request.getParameter("prdName");
		int prdPrice = Integer.parseInt(request.getParameter("prdPrice"));
		String prdCompany = request.getParameter("prdCompany");
		LocalDate prdDate = LocalDate.parse(request.getParameter("prdDate"));
		int prdStock = Integer.parseInt(request.getParameter("prdStock"));
		
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", prdDate);
		model.addAttribute("prdStock", prdStock);
		
		return "/product/productResult";
		
	}
	
	@RequestMapping("/product/newProduct2")
	public String createProduct2(String prdNo, String prdName, int prdPrice, String prdCompany, String prdDate, int prdStock, Model model) {
		
		LocalDate date = LocalDate.parse(prdDate);
		
		model.addAttribute("prdNo", prdNo);
		model.addAttribute("prdName", prdName);
		model.addAttribute("prdPrice", prdPrice);
		model.addAttribute("prdCompany", prdCompany);
		model.addAttribute("prdDate", date);
		model.addAttribute("prdStock", prdStock);
		
		return "/product/productResult";
		
	}
	
	@RequestMapping("/product/newProduct3")
	public String createProduct3(Product product, Model model) {
		
		System.out.println(product.getPrdNo());
		System.out.println(product.getPrdName());
		System.out.println(product.getPrdPrice());
		System.out.println(product.getPrdCompany());
		System.out.println(product.getPrdDate());
		System.out.println(product.getPrdStock());
		
		LocalDate date = LocalDate.parse(product.getPrdDate()); 
		
		model.addAttribute("prdNo", product.getPrdNo());
		model.addAttribute("prdName", product.getPrdName());
		model.addAttribute("prdPrice",product.getPrdPrice());
		model.addAttribute("prdCompany", product.getPrdCompany());
		model.addAttribute("prdDate", product.getPrdDate());
		model.addAttribute("prdStock", product.getPrdStock());
		
		return "/product/productResult";
		
	}
	
	@RequestMapping("/product/newProduct4") 
	public String createProduct4(@ModelAttribute Product product) {
		return "/product/productResult2";
	}
	

}
