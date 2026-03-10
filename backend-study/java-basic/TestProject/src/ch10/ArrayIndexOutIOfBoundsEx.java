package ch10;

public class ArrayIndexOutIOfBoundsEx {

	// mian 호출시 값 전달 : 이클립스 메뉴 Run - Run Config~ - 클래스 선택 - Args 텝에 값 입력
	public static void main(String[] args) {
		// 배열 범위 벗어나면 발생하는 오류
		String data1 = args[0]; // java.lang.ArrayIndexOutOfBoundsException
		String data2 = args[1];

		System.out.println("args[0]" + data1);
		System.out.println("args[1]" + data2);

		if (args.length == 2) {
			data1 = args[0];
			data2 = args[1];

			System.out.println("args[0]" + data1);
			System.out.println("args[1]" + data2);
		} else {
			System.out.println("ArrayIndexOutOfBoundsException 오류 발생");
		}

	}

}
