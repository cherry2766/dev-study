package ch11.sec04;

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
