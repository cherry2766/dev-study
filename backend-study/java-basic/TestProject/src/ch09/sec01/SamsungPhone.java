package ch09.sec01;

// 인터페이스 구현 클래스에 오버라이딩하는 메서드 원형 추가 : 메뉴 Source - Override/implements Methods
public class SamsungPhone implements ISmartPhone {

	String name;

	public SamsungPhone() {
		name = "삼성폰";
	}

	@Override
	public void sendCall() {
		System.out.println(name + "으로 전화를 겁니다");
	}

	@Override
	public void receiveCall() {

	}

	@Override
	public void sendSMS() {

	}

	@Override
	public void receiveSMS() {

	}

}
