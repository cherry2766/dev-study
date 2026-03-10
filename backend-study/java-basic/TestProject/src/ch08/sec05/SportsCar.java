package ch08.sec05;

public class SportsCar extends MyCar {

	@Override
	public void speedUp() {
		speed += 10;
	}

	// final 메서드는 재정의 불가
	/*@Override
	public void stop() {
		System.out.println("스포츠카를 멈춤");
		speed = 0;
	}*/
}
