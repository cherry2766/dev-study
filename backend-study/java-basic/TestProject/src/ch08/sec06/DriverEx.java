package ch08.sec06;

public class DriverEx {

	public static void main(String[] args) {
		// 매개변수 다형성 예시
		
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		// 인수 전달 시 서브클래스 타입의 인수를 전달
		// 한개의 매개변수에 두개 타입을 인수로 전달 가능 ~ 매개변수 다형성
		driver.drive(bus);
		driver.drive(taxi);

	}

}
