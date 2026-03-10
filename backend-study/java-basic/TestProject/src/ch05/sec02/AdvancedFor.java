package ch05.sec02;

public class AdvancedFor {

	public static void main(String[] args) {
		// 배열과 같은 집합 구조 for문에 적용하기 위한 문법
		int[] scores = {95,71,84,93,89};
		int sum = 0;
		
		// 반복요소로 배열등을 사용할 수 있음
		for(int score : scores) {
			sum += score;
		}

	}

}
