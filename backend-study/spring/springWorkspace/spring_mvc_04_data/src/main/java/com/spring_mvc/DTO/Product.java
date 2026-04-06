package com.spring_mvc.DTO;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Product {
	private String prdNo;
	private String prdName;
	private int prdPrice;
	private String prdMaker;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date prdDate;
	private String prdStock;
	
	public String getPrdNo() {
		return prdNo;
	}
	public void setPrdNo(String prdNo) {
		this.prdNo = prdNo;
	}
	public String getPrdName() {
		return prdName;
	}
	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}
	public int getPrdPrice() {
		return prdPrice;
	}
	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}
	public String getPrdMaker() {
		return prdMaker;
	}
	public void setPrdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}
	public Date getPrdDate() {
		return prdDate;
	}
	public void setPrdDate(Date prdDate) {
		this.prdDate = prdDate;
	}
	public String getPrdStock() {
		return prdStock;
	}
	public void setPrdStock(String prdStock) {
		this.prdStock = prdStock;
	}
		
}
