package ch06.sec07;

public class FinalMain {

	public static void main(String[] args) {
		// final 사용 예제
		Final fi1 = new Final("홍길동", "1234");
		fi1.name = "김길동";
		// fi1.ssn = "5678"; //ssn은 상수이므로 대입연산 불가능함

		System.out.println(fi1.nation); // 접근해서 data 사용은 가능

	}

}
