package com.spring_mvc.jdbc2.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.jdbc2.Repo.ProductDAO;
import com.spring_mvc.jdbc2.VO.ProductDTO;

@Controller
public class ProductController {
	
	private final ProductDAO dao;

    @Autowired
    public ProductController(ProductDAO dao) {
        this.dao = dao;
    }
    
    @RequestMapping("/")
    public String viewIndex() {
		return "index";
	}
    
    @RequestMapping("product/productSelect")
    public String productSelect(Model model) {
    	ArrayList<ProductDTO> prdList = dao.productSelect();
    	model.addAttribute("prdList",prdList);
    	return "product/productSelectRes";
    }
}
