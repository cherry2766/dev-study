package ch06.sec05;

public class ShareMain {

	public static void main(String[] args) {
		// static 활용 공유변수 가용
		Share s1, s2;
		s1 = new Share(); // 객체 인스턴스
		s1.set(5); // 인스턴스 필드와 스테틱 필드 전부 변경됨

		System.out.println("s1의 a : " + s1.showA());
		System.out.println("s1의 staticA : " + s1.showstaticA()); // static 메서드 객체 통한 접근 권장하지 않음

		s2 = new Share();
		s2.set(100); // 인스턴스 필드와 스테틱 필드 전부 변경됨

		System.out.println("s2의 a : " + s2.showA());
		System.out.println("s2의 staticA : " + s2.showstaticA());

		System.out.println("Share 클래스 staticA : " + Share.showstaticA()); // 클래스 통해서 static 사용
	}

}
