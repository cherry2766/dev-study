package ch11.sec04;

public class GenMethodEx {

	public static void main(String[] args) {
		// 제네릭 메서드 사용 : 파라미터 타입 구체화
		Box<Integer> box = Util.<Integer>boxing(100);
		int value = box.get();

		// 메서드 파라미터 구체화 추정 : 홍길동을 보고 T를 문자열로 추정
		// Util.<String>boxing("홍길동");
		Box<String> box2 = Util.boxing("홍길동");
		String name = box2.get();

		System.out.println(value + " " + name);

		////////////////////////////////////////////////////
		// 멀티타입 제네릭 메서드 사용 예시

		Pair<Integer, String> p1 = new Pair<>();
		Pair<Integer, String> p2 = new Pair<>();

		p1.setKey(1);
		p1.setValue("사과");

		p2.setKey(2);
		p2.setValue("사과");

		boolean result = Util.<Integer, String>compare(p1, p2);
		if (result)
			System.out.println("논리적으로 동등한 객체 입니다");
		else
			System.out.println("논리적으로 동등하지 않은 객체 입니다");

		Pair<String, String> p3 = new Pair<>("user01", "홍길동");
		Pair<String, String> p4 = new Pair<>("user01", "홍길동");

		result = Util.compare(p3, p4);
		if (result)
			System.out.println("논리적으로 동등한 객체 입니다");
		else
			System.out.println("논리적으로 동등하지 않은 객체 입니다");

	}

}
