package ch08.sec04;

public class OverrideEx {

	public static void main(String[] args) {
		// 메서드 재정의
		int r = 10;
		// super 클래스 객체
		Calculator cal = new Calculator();
		System.out.println("원의 넓이 : " + cal.areaCircle(r));
		System.out.println();

		// sub 클래스 객체
		Computer com = new Computer();
		System.out.println("원의 넓이 : " + com.areaCircle(r));
		// 재정의 없으면 부모 클래스 메서드 호출
		
		// 재정의 후 부모클래스 메서드 호출 예제
		SuperAirplane sa = new SuperAirplane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = SuperAirplane.SUPERSONIC;
		sa.fly();
		sa.flyMode = SuperAirplane.NORMAL;
		sa.fly();
		sa.land();
	}

}
