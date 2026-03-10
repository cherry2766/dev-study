package ch08.sec07;

// 추상 클래스
public abstract class DrawingObject {
	public String penColor;

	// draw() 메서드는 반드시 필요하지만 어떤걸 그릴지는 결정되지 않은 상태
	// 추상 메서드로 구성 - 상속받은 클래스가 draw() 메서드 구체화 진행
	public abstract void draw();
}
