package ch09.sec02;

public class RCMain {

	public static void main(String[] args) {
		// 인터페이스 참조변수: 다형성
		RemoteControl rc = null;

		// TV 객체를 인터페이스 참조변수 대입
		rc = new TV();
		rc.turnOn();
		rc.setVolume(100);
		rc.setMute(true);
		rc.turnOff();

		TV tv = new TV();
		tv.turnOn();
		tv.setVolume(-50);
		tv.setMute(true);
		tv.setMute(false);
		tv.turnOff();

		// 정적 메서드 사용
		RemoteControl.changeBattery();

		// 디폴트 메서드 사용
		rc = new Audio();
		rc.setMute(true);
		rc.setMute(false);

		// 다중 인터페이스 구현 클래스 객체를 각각 인터페이스 참조변수에 대입
		ISearchable sb = null;
		rc = new SmartTelevision();
		sb = new SmartTelevision();

		// 접근 가능한 메서드
		// rc 인터페이스에 포함된 추상메서드와 default만 접근 가능
		// search()는 다른 인터페이스 추상메서드기 때문에 접근 불가능
		// rc.search("aaa");
		sb.search("www.naver.com");
		// sb.turnOff(); // 해당 인터페이스의 추상, 디폴트 메서드만 접근 가능
	}

}
