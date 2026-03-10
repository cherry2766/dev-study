package ch08.sec04;

public class SuperAirplane extends Airplane {
	static final int NORMAL = 1;
	static final int SUPERSONIC = 2;

	int flyMode = NORMAL;

	@Override
	public void fly() {
		// flyMode에 따라 비행을 결정
		if (flyMode == SUPERSONIC) {
			System.out.println("초음속 비행합니다");
		} else {
			super.fly(); // 재정의 되었지만 부모 클래스 메서드 호출 가능(super 참조)
		}
	}
}
