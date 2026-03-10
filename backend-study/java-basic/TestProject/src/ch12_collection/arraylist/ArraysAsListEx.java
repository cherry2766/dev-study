package ch12_collection.arraylist;

import java.util.Arrays;
import java.util.List;

public class ArraysAsListEx {

	public static void main(String[] args) {
		// 고정된 객체들로 ArrayList 구성
		// 항목값이 고정됨 : 추가, 삭제 불가능함
		List<String> list1 = Arrays.asList("홍길동", "신길동", "김자바");
		for (String name : list1) {
			System.out.println(name);
		}
		// list1.add("김길동"); //오류발생 add 제공되지 않음
		// list1.remove(0); //오류발생 remove 제공되지 않음
		for (String name : list1) {
			System.out.println(name);
		}

		List<Integer> list2 = Arrays.asList(1, 2, 3);
		for (int num : list2) {
			System.out.println(num);
		}

	}

}
