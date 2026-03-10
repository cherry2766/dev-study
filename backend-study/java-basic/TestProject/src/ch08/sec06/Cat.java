package ch08.sec06;

public class Cat extends Animal{
	
	@Override
	public void show() {
		System.out.println("고양이 입니다");
	}
	@Override
	public void sound() {
		System.out.println("야옹");
	}
	
	public void catMethod() {
		System.out.println("catMethod 입니다");
	}
}
