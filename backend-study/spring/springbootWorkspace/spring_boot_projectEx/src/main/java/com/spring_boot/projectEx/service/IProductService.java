package com.spring_boot.projectEx.service;

import java.util.ArrayList;

import com.spring_boot.projectEx.dto.ProductDTO;

public interface IProductService {
	
	public ArrayList<ProductDTO> listCtgProduct(String ctgId); 
	public ProductDTO detailViewProduct(String prdNo);
	void insertProduct(ProductDTO dto);
	void updateProduct(ProductDTO dto);
	ArrayList<ProductDTO> getAllProducts();
	void deleteProduct(String prdNo);
}
