package ch09.sec01;

// 스마트폰이 반드시 포함해야 하는 기능을 나열함 - 프로젝트 관리자가 작성해서 개발자에게 전달함
public interface ISmartPhone {
	public void sendCall(); // 전화걸기

	public void receiveCall(); // 전화받기

	public void sendSMS(); // 문자전송

	public void receiveSMS(); // 문자받기
}
