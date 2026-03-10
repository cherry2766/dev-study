package ch06.sec06;

public class SingletonMain {

	public static void main(String[] args) {
		// 불가능함 - 생성자가 1개 있는데, 그 생성자가 클래스 외부 접근 불가한 상황
		// Singleton sg1 = new Singleton();
		// Singleton sg2 = new Singleton();
		
		// 멤버필드 직접 접근 불가능하게 private 선언되어 있음
		// Singleton s1 = Singleton.singleton;
		// Singleton s2 = Singleton.singleton;
		
		// 간접으로 객체 참조값 받아 쓸 수 있도록 메서드 추가되어 있음
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		// s1, s2 동일 객체 참조
		
		if(s1==s2) {
			System.out.println("동일 객체 임");
		}else {
			System.out.println("다른 객체 임");
		}
		
		if(s3==s2) {
			System.out.println("동일 객체 임");
		}else {
			System.out.println("다른 객체 임");
		}

	}

}
