package ch11.sec04;

public class Util {
	// 제네릭 메서드 : 파라미터 타입은 호출될때 구체화 됨
	public static <T> Box<T> boxing(T t) {
		Box<T> box = new Box<T>();
		box.set(t);
		return box;
	}
	
	// 멀티타입 사용 제네릭 메서드
	// 두 객체를 전달 받아서 동일한지 확인하는 메서드
	public static <K,V> boolean compare(Pair<K,V> p1,Pair<K,V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
}
