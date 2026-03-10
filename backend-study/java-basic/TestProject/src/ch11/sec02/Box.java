package ch11.sec02;

// 필드의 타입이 결정되지 않은 경우
// 결정되지 않은 타입을 T 로 약속했음
// 객체 생성 시 T를 구체화시켜야 함
// 제네릭 사용
public class Box<T> {

	private T object;

	public void set(T object) {
		this.object = object;
	}

	public T get() {
		return object;
	}
}
