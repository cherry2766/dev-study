package ch12_collection.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map<String, String> wordList = new HashMap<>();

		while (true) {
			System.out.println("** 단어 추가 **");
			System.out.print("영단어 입력 (종료: exit): ");
			String eng = sc.next();
			if (eng.equals("exit"))
				break;
			System.out.print("단어 뜻 입력 : ");
			String kor = sc.next();

			wordList.put(eng, kor);

		}
		while (true) {
			System.out.print("찾고 싶은 단어는? (종료: exit) ");
			String searchWord = sc.next();

			if (searchWord.equals("exit")) {
				System.out.println("프로그램 종료");
				break;
			}

			Set<String> wordSet = wordList.keySet();
			boolean found = false;

			for (String word : wordSet) {
				String value = wordList.get(word);
				if (word.equals(searchWord)) {
					System.out.println(value);
					found = true;
					break;
				}
			}
			if (!found) {
				System.out.println("단어가 없습니다.");
			}
		}

	}

}
