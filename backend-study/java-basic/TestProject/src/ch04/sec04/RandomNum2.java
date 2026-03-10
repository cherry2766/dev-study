package ch04.sec04;
import java.util.Random;

public class RandomNum2 {

	public static void main(String[] args) {
		// 난수 생성 방법 2
		// Random 클래스 : 자바 기본 객체가 아니므로 import
		// java.util.Random : static이 아니므로 참조변수(인스턴스)생성해서 사용
		Random r = new Random();
		
		for(int i=1; i<=10; i++) {
			int num = r.nextInt(10); // 0~9 범위 10개 중에서 생성
			System.out.println(num);
		}

	}

}
