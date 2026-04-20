package com.spring_boot_jpa_product.project.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.spring_boot_jpa_product.project.dto.ProductDTO;
import com.spring_boot_jpa_product.project.entity.ProductEntity;

@Service
@Primary
public class ProductService implements IProductService {
	@Autowired
	IProductServiceDataHandle productServiceDataHandle;
	
	
	@Override
	public ArrayList<ProductDTO> productSearch(HashMap<String, String> param) {
		ArrayList<ProductEntity> entityList = productServiceDataHandle.productSearch(param); //entity 반환 받아서
		ArrayList<ProductDTO> list = new ArrayList<>(); //DTO로 변환 후 반환
		
		//entity -> dto
		for(ProductEntity entity : entityList) {
			ProductDTO dto = ProductDTO.toDTO(entity);
			list.add(dto);
		}
		return list;
	}

	@Override
	public ArrayList<ProductDTO> listAllProduct() {
		// dao -> servicedatahandle에 의해 entity 반환
		ArrayList<ProductEntity> entityList = productServiceDataHandle.listAllProduct();
		// controller에 dto로 전송
		ArrayList<ProductDTO> dtoList = new ArrayList<>();

		for (ProductEntity entity : entityList) {
			ProductDTO dto = ProductDTO.toDTO(entity);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public void insertProduct(ProductDTO prdVo) {
		// dto->entity 변환해서 전달
		ProductEntity entity = ProductEntity.toEntity(prdVo);
		productServiceDataHandle.insertProduct(entity);

	}

	@Override
	public void updateProduct(ProductDTO prdVo) {
		// dto->entity 변환해서 전달
		ProductEntity entity = ProductEntity.toEntity(prdVo);
		productServiceDataHandle.updateProduct(entity);

	}

	@Override
	public void deleteProduct(String prdNo) {
		productServiceDataHandle.deleteProduct(prdNo);

	}

	@Override
	public ProductDTO detailViewProduct(String prdNo) {
		Optional<ProductEntity> entity = productServiceDataHandle.detailViewProduct(prdNo);
		//Optional 객체에 저장된 원소 추출하려면 .get()
		ProductDTO dto = ProductDTO.toDTO(entity.get());
		return dto;
	}

	@Override
	public String prdNoCheck(String prdNo) {
		return productServiceDataHandle.prdNoCheck(prdNo);
	}

}
