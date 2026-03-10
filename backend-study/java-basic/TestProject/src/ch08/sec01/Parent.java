package ch08.sec01;

public class Parent {
	private int p;
	protected int p2; // 접근제한자 생략과 동일
	
	public void setParent() {
		p = 10;
		p2 = 100;
	}
	
	public void showParent() {
		System.out.println("부모 클래스 p : " + p);
	}
	
}
