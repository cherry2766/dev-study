package ch12_collection.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListGenEx {

	public static void main(String[] args) {
		// ArrayList 제네릭타입 사용

		List<String> list = new ArrayList<>();

		list.add("Java");
		list.add("JDBC");
		list.add("Servlet/JSP");
		list.add(2, "DataBase");
		list.add("MyBATIS");

		// 항목수 반환
		int size = list.size();
		System.out.println("총 항목 수 : " + size);
		System.out.println();

		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);// String 타입으로 구체화
		}

		System.out.println();
		String skill = list.get(2);
		System.out.println(2 + ":" + skill);

		// 중간 공간을 비워놓지 않는다 : 이동이 발생
		list.remove(2); // 특정 인덱스 값을 삭제하면 2번 인덱스 공간은 이후 항목들이 하나씩 이동하면서 채움
		list.remove(2);
		list.remove("MyBATIS"); // 특정 항목 삭제

		System.out.println();
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + ":" + str);
		}
		
		System.out.println();
		for(String value : list) {
			System.out.println(value);
		}
		
		//문자열 : 문자열 개수 반환(length())
		System.out.println();
		System.out.println("각 항목의 문자 수");
		for(String value : list) {
			System.out.println(value + ":" + value.length());
		}
	}
}
