package ch06.sec04;

public class BookThisMethod {
	String title;
	String author;
	int price;

	// 매개변수가 없는 기본 생성자
	BookThisMethod() {
		this("미정", "미정"); // 현재 클래서 내의 다른 생성자 호출
		// this("미정", 0); // this 메서드는 무조건 첫행에만 표현되어야 함, 두번 사용(호출) 불가능,
		price = 0;
	}

	BookThisMethod(String title, String author) {
		this.title = title;
		this.author = author;
	}

	// 매개변수가 2개인 생성자, 위 생성자와는 매개변수 타입이 달라서 구별됨
	BookThisMethod(String title, int price) {
		this.title = title;
		this.price = price;
	}

}
