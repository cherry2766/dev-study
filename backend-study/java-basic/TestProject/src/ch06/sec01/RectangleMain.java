package ch06.sec01;

public class RectangleMain {

	public static void main(String[] args) {
		// Rectangle class 사용 예시
		Rectangle rec;
		rec = new Rectangle(); // 생성자 함수

		// 사각형 넓이 계산
		// 객체 인스턴스로 private 속성에는 접근 불가
		// rec.height =20;
		// rec.width =10; //main에서 클래스 객체 속성에 직접 접근 값 저장
		// 필드 초기화 없이 메서드 호출
		rec.area();

		rec.input(); // 클래스 객체 메서드를 통해 속성에 값 저장
		rec.area();
	}

}
