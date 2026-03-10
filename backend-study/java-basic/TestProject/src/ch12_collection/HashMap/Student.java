package ch12_collection.HashMap;

public class Student {
	private String stdNo;
	private String stdName;

	public Student(String stdNo, String stdName) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
	}

	public String getStdNo() {
		return stdNo;
	}

	public void setStdNo(String stdNo) {
		this.stdNo = stdNo;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	@Override
	public int hashCode() {
		// 학번과 이름이 같으면 동일한 값 리턴하도록 구성
		System.out.println(stdNo.hashCode() + stdName.hashCode());
		return stdNo.hashCode() + stdName.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// Student 객체 인지 확인
		if (obj instanceof Student) {
			// Student 타입 객체라면 Student 타입으로 형변환
			Student student = (Student) obj;
			return (stdNo.equals(student.stdNo)) && (stdName.equals(student.stdName));
		} else {
			return false;
		}

	}

}
