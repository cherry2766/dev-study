package com.spring_aop.xml2;

public class Evaluation {
	private int korScore;
	private int engScore;
	private int mathScore;
	
	
	public int getKorScore() {
		return korScore;
	}
	public void setKorScore(int korScore) {
		this.korScore = korScore;
	}
	public int getEngScore() {
		return engScore;
	}
	public void setEngScore(int engScore) {
		this.engScore = engScore;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	
	public void showResult() {
		System.out.println("총점 : " + (korScore + engScore + mathScore));
		System.out.println("평균 : " + (korScore + engScore + mathScore)/3);
	}
	
	
}
