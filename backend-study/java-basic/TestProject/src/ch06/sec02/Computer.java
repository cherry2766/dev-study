package ch06.sec02;

public class Computer {
	// 매개변수로 배열 전달 받아 배열의 요소값을 모두 더한 결과를 반환
	// 배열은 참조객체이므로 참조값이 전달됨
	public int sum1(int[] values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum;
	}

	// 매개변수의 값의 정수형 리스트 전달
	// ... : 전달된 값의 수에 따라 자동으로 배열로 생성, 인수로 값의 리스트가 전달
	int sum2(int ... values) {
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
}
