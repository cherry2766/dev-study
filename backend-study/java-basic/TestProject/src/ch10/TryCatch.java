package ch10;

public class TryCatch {

	public static void main(String[] args) {
		// try ~ catch
		int[] arr = { 1, 2, 3 };
		// System.out.println(arr[5]); 예외 발생 강제 종료

		try {
			System.out.println(arr[5]); // 예외 발생
			System.out.println("test"); // 실행되지 않음
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스 범위 벗어남");
		}

		System.out.println("프로그램 종료합니다");
	}

}
