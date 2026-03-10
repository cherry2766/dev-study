package ch03.sec02;
import java.util.Scanner;

public class TimeCalculation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputSeconds, hour, minute, second;
		
		System.out.print("시간 입력 (초) : ");
		inputSeconds = sc.nextInt();
		hour = inputSeconds / 3600;
		minute = (inputSeconds % 3600) / 60;
		second = inputSeconds % 60;
				
		System.out.print(inputSeconds + "초는 " + hour + "시간, " + minute +"분, " + second + "초입니다.");		
				
		sc.close();
	}

}
