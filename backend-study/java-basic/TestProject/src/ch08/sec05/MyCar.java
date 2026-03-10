package ch08.sec05;

public class MyCar {
	public int speed;

	public void speedUp() {
		speed += 1;
	}
	
	// final 메서드- 상속은 되지만 마음대로 수정 불가능하게 구성
	public final void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}
}
