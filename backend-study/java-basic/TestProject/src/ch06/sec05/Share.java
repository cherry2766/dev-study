package ch06.sec05;

public class Share {
	int a;
	static int staticA;

	/////////////////////
	/// 메서드
	public void set(int n) { // 인스턴스 메서드
		a += n;
		staticA += n;
	}
	
	public int showA() { // 인스턴스 메서드
		return a;
	}
	
	public static int showstaticA() { // static 메서드
		return staticA;
	}
}
