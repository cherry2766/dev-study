package ch06.sec02;

public class ComputerMain {

	public static void main(String[] args) {
		// 메서드 인수의 전달
		Computer myCom = new Computer();

		int[] values = { 1, 2, 3 };

		// 인수로 배열 참조변수 전달

		System.out.println(myCom.sum1(values)); // 참조값 전달

		System.out.println(myCom.sum2(1, 2, 3)); // 기본값 전달 - 여러개의 인수를 전달하면 메서드에서 전달된 인수를 배열로 생성해서 사용
		System.out.println(myCom.sum2(1, 2));
		System.out.println(myCom.sum2(1, 2, 3, 4, 5));

	}

}
