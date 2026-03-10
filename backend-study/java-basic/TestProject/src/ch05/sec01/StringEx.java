package ch05.sec01;

public class StringEx {

	public static void main(String[] args) {
		// 참조타입 String 예제
		// String 타입의 참조 변수 생성방법 1
		// 문자열을 일반변수처럼 사용, 문자열 변수 생성할때마다 객체를 생성하면 메모리 부족이 일어날 수 있음
		// = 활용해서 생성한 객체들은 힙 영역 안에서도 따로 분리해 모아놓고
		// 생성할 객체(문자열 값)가 이미 만들어져 있으면(문자열 값이 동일하면) 새로 객체 생성하지 않고 기존 객체 참조 
		String name1 = "홍길동";
		String name2 = "홍길동";
		
		// name1과 name2는 서로 동등객체인지 독립객체인지 확인, 참조변수인 경우 == 같은 객체를 참조하고있는지의 여부 반환
		System.out.println("name1과 name2 참조변수는 동일 객체 참조하는지의 여부? " + (name1 == name2));
		System.out.println("name1과 name2 참조변수가 참조하는 객체는 동일 값을 갖는지의 여부? " + (name1.equals(name2)));
		
		// String 타입의 참조 변수 생성방법 2 - new 연산자로 새로 메모리 할당 후 할당된 메모리에 객체 생성
		// 독립적인 새로운 객체 생성됨
		String name3 = new String("홍길동");
		String name4 = new String("홍길동");
		
		// name3과 name4는 서로 동등객체인지 독립객체인지 확인, 참조변수인 경우 == 같은 객체를 참조하고있는지의 여부 반환
		System.out.println("name3과 name4 참조변수는 동일 객체 참조하는지의 여부? " + (name3 == name4));
		System.out.println("name3과 name4 참조변수가 참조하는 객체는 동일 값을 갖는지의 여부? " + (name3.equals(name4)));
		
		//////////////////////////////////////////////////////////////////////////////////////////////////
		// name1과 name4는 서로 동등객체인지 독립객체인지 확인, 참조변수인 경우 == 같은 객체를 참조하고있는지의 여부 반환
		System.out.println("name1과 name4 참조변수는 동일 객체 참조하는지의 여부? " + (name1 == name4));
		System.out.println("name1과 name4 참조변수가 참조하는 객체는 동일 값을 갖는지의 여부? " + (name1.equals(name4)));

	}

}
