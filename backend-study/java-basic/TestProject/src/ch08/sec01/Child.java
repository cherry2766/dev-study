package ch08.sec01;

//Parent 클래스 상속 받음
public class Child extends Parent {
	private int c;

	public void setChild() {
		c = 20;
	}

	public void showChild() {
		System.out.println("부모 클래스 p2 : " + p2); //protected 접근 제한일 경우 동일 패키지면 접근 가능
		showParent(); // Parent 클래스 메서드(상속 받았으므로 사용 가능)
		System.out.println("자식 클래스 c : " + c);
	}
}
