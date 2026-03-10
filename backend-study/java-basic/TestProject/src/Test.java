// 현재 소스에 여러 클래스가 있을때는 public 접근 권한자는 한개의 클래스만 가능
class A {
	
}

class B {
	
}

public class Test {

	public static void main(String[] args) {
		// 프로그램 시작점(실행을 위해서는 반드시 필요)
		// static 이므로 객체 없이 바로 사용 가능
		// 실행할 때 런타임(자바)이 main을 호출하는 것부터 시작
		// 출력을 위한 코드
		
		// 문장 블럭 마지막에는 세미콜론 필수
		System.out.println("test"
				+"");
		System.out.println("test 입니다");
		
		{
			//영역 범위 표시(클래스, 메서드, 조건문, 반복문 등)
		}
	}

}
