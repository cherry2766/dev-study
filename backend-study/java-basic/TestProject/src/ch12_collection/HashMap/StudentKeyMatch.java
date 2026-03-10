package ch12_collection.HashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StudentKeyMatch {

	public static void main(String[] args) {
		// key를 참조 타입으로 사용
		Map<Student, Integer> map = new HashMap<>();
		map.put(new Student("1", "홍길동"), 90);
		map.put(new Student("2", "김길동"), 80);
		map.put(new Student("3", "박길동"), 100); // key : 독립적인 Student 인스턴스
		map.put(new Student("3", "박길동"), 99);
		// 새로운 entry 추가 : Student 클래스의 hashCode()와 equals() 재정의 하면 동등객체로 처리 가능

		Set<Student> ket_set = map.keySet();
		for (Student stdKey : ket_set) {
			System.out.println(stdKey.getStdNo() + " " + stdKey.getStdName() + " " + map.get(stdKey));
		}

		System.out.println("총 Entry 수 : " + map.size());
		// 사용자 정의 클래스에서 객체를 HashMap의 키로 사용하려면
		// hashCode()와 equals() 메서드를 재정의해서 동등객체가 될 조건을 정해야 함

	}

}
