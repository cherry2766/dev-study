package ch10;

public class TryCatchMultiOrder {

	public static void main(String[] args) {
		// 다중 catch
		// catch 순서
		int[] arr = { 1, 2, 3 };

		try {
			System.out.println(arr[5]); // 배열 범위 오류 가능성
			int value1 = Integer.parseInt("a1"); // 수치 변경 불가능한 data가 올 수 있는 오류 가능성

		} catch (Exception e) { // 모든 예외 처리 클래스 - 아래 있는 catch 블럭에는 도달하지 않음 여기서 모두 처리
			System.out.println("예외가 발생했습니다");
			/*
			 * } catch (ArrayIndexOutOfBoundsException e) { // 배열 범위만 처리 클래스
			 * System.out.println("배열 인덱스 범위 벗어남");
			 */
		}
		// 다중 catch를 사용할 경우에는 하위 클래스 먼저 표시, 상위 클래스 표시(Exception 은 마지막에)
		System.out.println("프로그램 종료합니다");

	}

}
