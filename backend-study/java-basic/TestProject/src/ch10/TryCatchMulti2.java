package ch10;

public class TryCatchMulti2 {

	public static void main(String[] args) {
		// 다중 catch
		int[] arr = { 1, 2, 3 };

		try {
			System.out.println(arr[5]); // 배열 범위 오류 가능성
			int value1 = Integer.parseInt("a1"); // 수치 변경 불가능한 data가 올 수 있는 오류 가능성

		} catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
			// catch의 exception을 | 로 동시에 표현 가능
			System.out.println("배열이나 parseInt에서 예외 발생");
		} catch (Exception e) {
			System.out.println("실행 오류 발생");
		}

		System.out.println("프로그램 종료합니다");

	}

}
