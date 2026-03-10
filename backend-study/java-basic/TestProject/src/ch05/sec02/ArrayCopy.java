package ch05.sec02;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		// 얕은 복사 : 참조 주소만 복사 (동일 객체 참조)
		// 참조 변수만 다르고 같은 위치의 객체 참조
		int[] a = {1,2,3,4};
		int[] b = a;
		
		// 변경 전 출력
		for(int i=0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i< b.length; i++) {
			System.out.print(b[i] + " ");
		}
		
		System.out.println();
		
		// a배열 원소값 변경
		a[0] = 100;
		
		// a배열 변경 후 출력
		for(int i=0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i< b.length; i++) {
			System.out.print(b[i] + " "); // 배열 b의 첫번째 값도 변경됨
		}
		
		///////////////////////////////////////////////////////////
		// 깊은 복사
		// 새로운 배열을 생성해서 원소값 각각을 복사
		
		int[] deepCopy = new int[4]; //새로운 배열 생성
		
		for(int i=0; i<a.length; i++) {
			deepCopy[i] = a[i];
		}
		System.out.println("\ndeepCopy 변경전 출력");
		
		// 변경 전 출력
		for(int i=0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i< deepCopy.length; i++) {
			System.out.print(deepCopy[i] + " ");
		}
		System.out.println();
		
		a[3] = 1000; //원본 변경
		
		// 변경 후 출력
		System.out.println("\ndeepCopy 변경후 출력");
		for(int i=0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i< deepCopy.length; i++) {
			System.out.print(deepCopy[i] + " "); //복사본 배열 변화 없음
		}
		System.out.println();
		
		//////////////////////////////////////////////////////////////
		// 메서드 활용한 DeepCopy : 원본 a 배열
		
		int[] deepCopy2 = a.clone(); //배열 객체가 제공하는 복사 메서드
		// Object.clone() : 객체 복사용 메서드, 동일 객체를 반환
		
		System.out.println("\ndeepCopy2 변경전 출력");
		
		// 변경 전 출력
		for(int i=0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i< deepCopy2.length; i++) {
			System.out.print(deepCopy2[i] + " ");
		}
		System.out.println();
		
		a[1] = 50; //원본 변경
		
		// 변경 후 출력
		System.out.println("\ndeepCopy2 변경후 출력");
		for(int i=0; i< a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
		for(int i=0; i< deepCopy2.length; i++) {
			System.out.print(deepCopy2[i] + " "); //복사본 배열 변화 없음
		}
		System.out.println();
		
		/////////////////////////////////////////////////////////////
		// Arrays.copyOf(원본,복사할 요소의 개수) :복사할 요소의 개수가 원본 길이보다 크면 초기값으로 채워짐
		
		int[] deepCopy3 = Arrays.copyOf(a, a.length);
		int[] deepCopy4 = Arrays.copyOf(a, a.length+3); //복사하면서 요소수도 확장
		int[] deepCopy5 = Arrays.copyOf(a, a.length-1); //일부 복사 제외
		System.out.println("========================");
		
		for(int i=0; i< deepCopy3.length; i++) {
			System.out.print(deepCopy3[i] + " "); 
		}
		System.out.println();
		
		for(int i=0; i< deepCopy4.length; i++) {
			System.out.print(deepCopy4[i] + " "); 
		}
		System.out.println();
		
		for(int i=0; i< deepCopy5.length; i++) {
			System.out.print(deepCopy5[i] + " "); 
		}
		System.out.println();
		
		////////////////////////////////////////////////////////////////////
		// Arrays.copyOfRange(원본배열, 시작인덱스, 끝인덱스-1) : 복사 범위 : 시작인덱스~ 끝인덱스-1까지 복사
		// a = [100, 50, 3, 1000]
		
		int[] test = Arrays.copyOfRange(a,1,3); // idx 1~2 => 3-1
		
		System.out.println();
		
		for(int i=0; i< test.length; i++) {
			System.out.print(test[i] + " "); 
		}
		System.out.println();
		
		/////////////////////////////////////////////////////////////////////
		// System.arraycopy(원본배열, 시작인덱스, 대상배열객체참조, 대상의 시작인덱스, 복사할 개수)
		
		int[] test2 = new int[10];
		// a = [100, 50, 3, 1000]
		System.arraycopy(a, 1, test2, 0, 2);
		
		System.out.println();
		
		for(int i=0; i< test2.length; i++) {
			System.out.print(test2[i] + " "); 
		}
		System.out.println();
		
		// 배열 크기 변경
		// 한번 생성하면 크기 변경 불가능, 깊은복사해서 크기를 수정해줘야함 Arrays.copyOf() <-주로 사용
		// a.length = 10; // 배열 length 읽기 전용임, 절대 수정 불가능
		
		int[] newA = Arrays.copyOf(a, 10); // 배열 공간 부족으로 깊은복사 진행, 배열 복사
		// 기존 배열 삭제
		// 배열은 객체, 모든 객체 삭제 시 참조변수에 null 대입
		a = null; // a가 참조하는 객체는 사용 불가, 객체의 주소를 a만 알고 있음, a참조 삭제하면 참조 방법이 사라짐
		// 이런 경우 해당 메모리는 자바 가비지콜렉터에 의해 자동 정리됨
		
		// int[] test4 = a[0];
		// NullPointerException 에러 발생
 	}

}
