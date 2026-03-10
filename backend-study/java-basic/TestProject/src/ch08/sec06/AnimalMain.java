package ch08.sec06;

public class AnimalMain {

	public static void main(String[] args) {
		Animal a = new Animal();
		a.sound();

		Cat c = new Cat();
		c.sound();

		Dog d = new Dog();
		d.sound();

		// 다형성 표현
		// 하나의 타입에 여러 객체를 대입할 수 있는 기능
		Animal ap = null;

		ap = new Cat(); // Animal 에 Cat 객체 참조 대입
		ap.show(); // 재정의 객체이므로 자식객체의 메서드가 호출
		ap.sound();
		ap.animalMethod(); // 상속된 animal 클래스 메서드 호출
		// ap.catMethod(); // Animal 클래스에 정의되어 있지 않은 cat 의 고유 메서드
		// cat 객체 참조해도 사용 불가
		((Cat) ap).catMethod(); // 강제 형변환

		ap = new Dog(); // Animal 에 Dog 객체 참조 대입
		ap.show(); // 재정의 객체이므로 자식객체의 메서드가 호출
		ap.sound();
		ap.animalMethod();
		((Dog) ap).dogMethod(); // 강제 형변환을 통해 sub 클래스 메서드 호출

		// 자식 객체의 메서드 사용
		// 1. 자식 객체 참조해야 함
		// 2. 강제 형변환을 통해 자식 객체 고유 참조 반환 가능
		Dog dg = (Dog) ap;
		dg.dogMethod();

		/////////////////////////////////////////////////////////////////////
		// 강제 형변환이 불가능한 예시
		// c 인스턴스 : cat 타입
		// a 인스턴스 : animal 타입
		// a를 Cat 타입으로 강제 형변환
		// a는 Cat 타입을 참조하고 있지 않음(강제 형변환 불가능)
		// c = (Cat) a; // 문법적 오류는 없음, 단 실행상태 오류 발생

		// 오류 발생을 해결하기 위해서 미리 타입검사 진행 후 형변환
		// 객체 instanceof 클래스명 연산자
		// 매개 값 타입 조사할 때 주로 사용하는 연산자

		System.out.println(a instanceof Cat);
		System.out.println(ap instanceof Dog);

		// 강제 형변환 전 형변환 타입을 참조하는지 확인하고 형변환
		if (a instanceof Cat)
			c = (Cat) a;
	}

}
