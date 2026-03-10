package ch05.sec01;

import java.util.Arrays;

public class ArrayEx {

	public static void main(String[] args) {
		// Array 정리
		// 같은 타입의 데이터를 연속된 공간에 저장하는 자료구조
		
		int[] arr; //배열에 저장된 요소의 타입을 선언할 때 결정해줘야 함
		//인스턴스 생성 - 배열의 정확한 크기를 알려줘야 인스턴스 생성할 수 있음
		//자바 배열은 동적할당 안됨(처음 생성시 크기(길이)를 결정하고 사용)
		//arr 배열의 크기는 12byte이기 때문에 배열이 생성되려면 연속된 12byte 공간이 있어야 함
		//예를들어, arr[0] 요소의 주소가 100번지라면 int 크기만큼 건너뛰면 arr[1]이 있어야 함
		arr = new int[3];
		
		// 배열변수(참조형변수) 선언 형식(2가지) - 저장되는 데이터의 타입은 모든 타입 가능
		int[] num; //해당 배열의 idx 접근하면 실제 값이 있음
		double[] average;
		String[] name; //해당 배열의 idx 접근하면 문자열 참조하는 주소
		
		int num2[];
		double average2[];
		String name2[];
		
		//배열의 메모리 공간 할당 : new
		int a[] = new int[5]; //선언과 동시에 할당
		int[] c;
		c = new int[5];
		
		//공간 크기 결정
		//int[5] test; // 선언하면서 크기 결정은 불가능 함, 배열 크기는 메모리 공간 할당할 때 결정
		//int test1[6];
		
		//배열은 공간 할당 시 초기값이 저장됨
		int[] a1 = new int[5]; // 초기값 0
		double[] d1 = new double[2]; // 초기값 0.0
		boolean[] b1 = new boolean[5]; // false
		String[] s = new String[5]; //초기값 null
		
		//항목의 기본값
		//byte,short,int : 0, long : 0L
		//float : 0.0f
		//참조타입: null
		//char : '\u0000' -> 유니코드 null 문자
		
		//배열 선언 할당하면서 바로 초기화 진행 (바로 초기화할때는 new 생략 가능)
		int[] i1 = {1,2,3,4,5};
		String[] nations = {"korea","japan","china"};
		int[] score = new int[] {90,80,55,70};
		
		//초기화 주의사항
		int[] test2;
		// test2 = {1,2,3,4,5}; // 오류! {}이용한 할당 및 초기화는 선언과 동시에만 사용할 수 있음
		// int[] score1 = new int[4] {90,80,55,70}; //[]의 요소 크기 결정은 초기화 진행시에는 불가능함
		test2 = new int[] {1,2,3,4,5}; //명시적 할당 후에 {} 사용 가능
		
		//길이가 0인 배열 생성 가능
		int[] score2 = new int[0];
		int[] score3 = new int[] {};
		int[] score4 = {};
		
		//배열 참조변수 출력
		System.out.println(score); //[I@2ff4acd0 -> 참조해야하는 객체의 가상주소(시작주소)가 출력됨
		//java에서 @는 주소를 표현하는 기호임
		//java 주소의 맨 앞에 첫문자가 [면 배열 참조 주소를 의미함
		//[[ 면 2차원 배열을 의미함
		
		//배열의 idx는 0번부터 시작
		System.out.println(score[0]);
		
		String[] flowers = {"해바라기","장미","진달래"};
		//배열 요소 접근 idx
		for(int i=0; i<flowers.length; i++) {
			System.out.print(flowers[i]+ " "); //요소 각각 접근 출력
		}
		
		System.out.println();
		
		//Array 클래스의 toString() 사용하면 전체 배열 값을 반환받을 수 있음
		System.out.println(Arrays.toString(flowers)); //배열 요소 집합 전체를 문자열로 반환함
		
		//배열의 크기 : length 속성
		System.out.println("flowers 배열의 크기 : " + flowers.length);
		System.out.println("길이가 없는(0인) 배열의 length 속성 : " + score2.length);

	}

}
