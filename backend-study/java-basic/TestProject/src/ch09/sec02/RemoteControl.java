package ch09.sec02;

public interface RemoteControl {
	// 상수필드 선언 : 인터페이스의 멤버필드는 public static final 이 컴파일 될 때 자동 삽입
	// 필드 구성하면 static 상수로 구성됨
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;

	// 추상메서드 선언 : abstract 생략해도 추상 메서드로 자동 처리 됨
	// 메서드 원형만 표현
	void turnOn();

	void turnOff();

	void setVolume(int volume);

	// 디폴트 메서드 선언 : 실행 블럭이 있는 메서드(구현 클래스가 소유하게 되는 메서드)
	// default 키워드 반드시 필요함
	// 접근제한 생략하면 public
	default void setMute(boolean mute) {
		if (mute) {
			System.out.println("무음 처리 합니다");
		} else {
			System.out.println("무음 해제 합니다");
		}
	}

	// 정적 메서드 선언 : 인터페이스 통해 호출되는 메서드(static)
	static void changeBattery() {
		System.out.println("배터리를 교체합니다");
	}

}
