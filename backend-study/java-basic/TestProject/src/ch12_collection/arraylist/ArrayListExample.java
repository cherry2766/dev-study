package ch12_collection.arraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListExample {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 4; i++) { // 사용자로부터 4개의 단어 입력 받기
			System.out.print("단어를 입력하세요>>");
			list.add(sc.next()); // 입력 받은 단어 리스트에 추가
		}
		System.out.println("------------------");
		System.out.println(list); // 리스트 출력

		String longWord = list.get(0); // 가장 긴 단어와 길이 초기화
		int valueLength = longWord.length();

		for (String word : list) { // 리스트에 있는 단어들 중 가장 긴 단어와 길이 찾아서 변수에 대입
			if (valueLength < word.length()) {
				longWord = word;
				valueLength = word.length();
			}
		}

		System.out.println("가장 긴 단어는 : " + longWord);
		System.out.println("가장 긴 단어의 길이는 : " + valueLength);

	}

}
