package ch08.sec03;

public class Manager extends Employee {
	private String position;

	// sub 클래스 생성자에서 super 클래스가 필요한 인수까지 받고 전달
	public Manager(String empNo, String name, String part, String position) {
		super(empNo, name, part);
		this.position = position;
	}

	// Manager 객체 정보 출력
	// 출력문 등에서 사용될때는 자동 호출되지만 일반 문장에서 사용시 직접 호출해야 함
	@Override
	public String toString() {
		return super.toString() + "\t" + position;
	}

}
