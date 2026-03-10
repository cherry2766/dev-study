package ch08.constructor_ex;

public class Worker {
	String joominNo;
	String name;
	
	public Worker(String joominNo,String name) {
		this.joominNo = joominNo;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "주민번호 : " + joominNo + "\n성명 : " + name ;
	}
}
