package ch05.sec04;

import java.util.Calendar;

public class EnumWeekEx {

	public static void main(String[] args) {
		// 열거타입 사용 예시
		Week today = null; // Week 객체타입과 동일, 초기값으로 null
		// today 참조변수가 참조할 데이터는 Week 객체 참조 (즉 Week 객체의 상수값만 대입 가능)

		// Calendar 클래스는 Instance 생성하는 메서드를 제공함 getInstance() 메서드
		// 이용해서 생성된 인스턴스 반환받도록 되어있음
		// Date, Calender, LocalDateTime : 날짜 및 요일, 시간을 반환받을 수 있음
		Calendar cal = Calendar.getInstance();
		// System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		int week = cal.get(Calendar.DAY_OF_WEEK); // 1~7까지의 정수 반환

		// week 변수의 값에 따라 today라는 참조변수에 Week 상수 참조 대입
		switch (week) {
		case 1:
			today = Week.SUNDAY;
			break;
		case 2:
			today = Week.MONDAY;
			break;
		case 3:
			today = Week.TUSEDAY;
			break;
		case 4:
			today = Week.WEDNESDAY;
			break;
		case 5:
			today = Week.THURSDAY;
			break;
		case 6:
			today = Week.FRIDAY;
			break;
		case 7:
			today = Week.SATURDAY;
			break;
		}

		System.out.println("오늘 요일 : " + today); // 객체 참조 변수를 print문에 적용하면 내부에 저장된 속성값을 출력해줌

		if (today == Week.SUNDAY) {
			System.out.println("일요일에는 축구를 합니다");
		} else {
			System.out.println("열심히 공부합시다");
		}

		// 열거객체 메서드
		today = Week.SUNDAY;
		Week day = Week.WEDNESDAY;
		String name = today.name(); // name() 메서드를 통해서 상수가 저장하는 문자열을 반환받음
		System.out.println(name);

		// 열거객체의 순번 리턴
		int ordinal = today.ordinal();
		System.out.println(ordinal); // 순번은 0부터 시작
		
		// 매개값과 순번을 비교
		int result1 = today.compareTo(day);
		int result2 = day.compareTo(today);
		System.out.println(result1); // 4 순번이 늦음
		System.out.println(result2); // -4 순번이 빠름
		
		// 매개값과 동일한 문자열을 갖는 열거 객체 리턴
		Week weekDay = Week.valueOf("SUNDAY");
		System.out.println(weekDay);
	}

}
