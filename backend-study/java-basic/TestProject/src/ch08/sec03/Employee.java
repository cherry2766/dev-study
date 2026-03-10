package ch08.sec03;

public class Employee {
	private String empNo, name, part;

	public Employee(String empNo, String name, String part) {
		this.empNo = empNo;
		this.name = name;
		this.part = part;

	}

	// Object 클래스에 의해 상속되어지는 toString() 메서드 재정의해서 멤버 필드의 값을 출력용으로 반환
	// @ 어노테이션 Override : 상속되어진 메서드를 재정의
	@Override
	public String toString() {
		return empNo + "\t" + name + "\t" + part;

	}

}
