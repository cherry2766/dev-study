package ch08.sec03;

class Super {
	// 상속되는 필드
	int x;
	int y;

	public Super() {
		x = 50;
		y = 5;
	}

}

class Sub extends Super {
	int x;
	int y;

	public Sub() {
		x = 10;
		y = 15;
	}

	public void show() {
		System.out.println("x : " + x); // sub 클래스의 x 출력
		System.out.println("super.x : " + super.x);
		System.out.println("this.y : " + this.y);
	}
}

public class superEx {

	public static void main(String[] args) {
		// 상속되는 필드의 구분 예제
		Sub sub = new Sub();
		sub.show();

	}

}
