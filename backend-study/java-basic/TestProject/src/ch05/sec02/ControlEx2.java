package ch05.sec02;
import java.util.Scanner;

public class ControlEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, depositAmount, withdrawalAmount;
		int balance = 0;
		
		while(true) {
			System.out.println("-------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------");
			
			System.out.print("선택> ");
			num = sc.nextInt();
			
			switch(num) {
				case 1 :
					System.out.print("예금액> ");
					depositAmount = sc.nextInt();
					balance += depositAmount;
					break;
				case 2 :
					System.out.print("출금액> ");
					withdrawalAmount = sc.nextInt();
					balance -= withdrawalAmount;
					break;
				case 3 :
					System.out.print("잔고> ");
					System.out.println(balance);
					break;
				case 4 :
					System.out.print("\n프로그램 종료");
					sc.close();
					return;
				default :
					System.out.println("** 잘못 입력하였습니다 **");
			}
		}
			
	}

}
