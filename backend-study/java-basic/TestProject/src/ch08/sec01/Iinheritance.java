package ch08.sec01;

public class Iinheritance {

	public static void main(String[] args) {
		// 상속예제
		
		Child ob = new Child();
		ob.setChild(); //sub 클래스 메서드 setChild(); 호출
		ob.setParent(); //super 클래스 메서드 호출
		ob.showChild(); //sub 클래스 메서드 호출
		
		Parent pb = new Parent();
		pb.setParent(); 
		pb.showParent();

	}
	

}
