package ch10;

public class TryCatchMulti {

	public static void main(String[] args) {
		// 다중 catch
		int[] arr = { 1, 2, 3 };

		try {
			System.out.println(arr[5]); // 배열 범위 오류 가능성
			int value1 = Integer.parseInt("a1"); // 수치 변경 불가능한 data가 올 수 있는 오류 가능성
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인덱스 범위 벗어남");
		} catch (NumberFormatException e) {
			System.out.println("정수 변환 불가능");
		}

		System.out.println("프로그램 종료합니다");

	}

}
