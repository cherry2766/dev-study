package com.spring_boot_jpa_product.project.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.spring_boot_jpa_product.project.dto.ProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//entity는 기본 생성자 필요, builder를 포함시키면 파라미터가 있는 생성자때문에 기본 생성자는 사용 불가능함
//entity를 사용하려면 기본 생성자 직접 생성해야함
@Entity
@Getter
@Builder
@NoArgsConstructor //entity가 필요
@AllArgsConstructor //builder가 필요
@Table(name="product")
public class ProductEntity {
	
	@Id //해당 필드는 기본키 컬럼으로 매핑
	private String prdNo;
	
	//DB데이블의 컬럼명(prd_name)과 필드명(prdName)이 다를 경우 바인딩 필요
	//entity를 통해 DB테이블 생성하는 경우 테이블에 컬럼으로 포함되어야 하는 필드에 @Column 사용
	//@Column(name="prd_name")
	private String prdName;
	private int prdPrice;
	private String prdCompany;
	private int prdStock;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prdDate;
	
	//DTO -> Entity 변환
	public static ProductEntity toEntity(ProductDTO dto) {
		return ProductEntity.builder()
				.prdNo(dto.getPrdNo())
				.prdName(dto.getPrdName())
				.prdPrice(dto.getPrdPrice())
				.prdCompany(dto.getPrdCompany())
				.prdStock(dto.getPrdStock())
				.prdDate(dto.getPrdDate())
				.build();
	}

}
