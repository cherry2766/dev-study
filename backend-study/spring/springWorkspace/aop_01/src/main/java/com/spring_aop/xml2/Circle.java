package com.spring_aop.xml2;

public class Circle {
	private int r;

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}
	
	public void showResult() {
		System.out.println("원의 면적 : " + (Math.PI * r * r));
		System.out.println("원의 둘레 : " + (Math.PI  * r * 2));
	}

}
