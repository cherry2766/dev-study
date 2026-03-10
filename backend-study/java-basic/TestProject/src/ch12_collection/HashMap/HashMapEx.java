package ch12_collection.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapEx {

	public static void main(String[] args) {
		// Map 컬렉션 생성
		// Map<Key, Value>
		Map<String, Integer> map = new HashMap<String, Integer>();

		// Map의 key는 중복될 수 없음 : entry 구별하는 용도 key

		// Map collection에 객체 저장 : put(Key, Value)
		// key 값이 중독되었음 => key값이 컬렉션에 존재하는지 확인 후 있으면 value만 수정, 없으면 새로운 entry 추가
		map.put("김길동", 85);
		map.put("홍길동", 90);
		map.put("동장군", 80);
		map.put("홍길동", 95); // key가 중복되었기 때문에 앞에서 put한 홍길동:90 entry의 value가 수정됨
		// String 클래스는 ""구성한 문자열 값이 같을 경우 동등객체가 될 수 있도록
		// hashCode()와 equals() 메서드가 재정의 되어 있음

		// 전체 entry 수 : size()
		System.out.println("총 entry 수 : " + map.size());

		// map.get(key) : 특정 키에 대한 value 추출
		System.out.println("key 홍길동에 대한 value : " + map.get("홍길동"));
		System.out.println();

		// Map.keySet() : 모든 entry의 key 객체를 반환(Set 타입으로 반환)
		// Set : 순서가 없고 중복값이 없는 컬렉션
		Set<String> keySet = map.keySet();

		// 모든 collection 클래스는 Iterator 인터페이스를 구현한다
		// iterator() : 컬렉션 순회를 가능하게 해주는 Iterator 객체를 반환함
		Iterator<String> keyIterator = keySet.iterator();

		// map의 전체 entry 출력
		// Iterator.hasNext() : 참조할 항목이 있는지의 여부 반환(true/false)
		while (keyIterator.hasNext()) {
			String key = keyIterator.next(); // 참조한 항목의 값을 반환하고 다음 참조쪽으로 이동
			int value = map.get(key);
			System.out.println("\t" + key + ": " + value);
		}

		for (String k : keySet) {
			int value = map.get(k);
			System.out.println("\t" + k + ": " + value);
		}

		// map.entrySet() : 모든 entry 반환 (Set 타입으로 반환 - Map은 entry의 중복은 없음)
		System.out.println();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			// 특정 entry의 key 추출 : entry.getKey()
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println("\t" + key + ": " + value);
		}

		System.out.println();
		// 모든 entry 삭제 : Map.clear();
		map.clear();
		System.out.println("총 entry 수 : " + map.size());

	}

}
