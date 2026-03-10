package ch04.sec01;
import java.util.Scanner;

public class IfNested {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num, pay;
		
		System.out.print("번호 입력(1.현금 2.카드) : ");
		num = sc.nextInt();
		
		if(num == 1 || num == 2) {
			System.out.print("지불액 입력 : ");
			pay =sc.nextInt();
			
			if(num == 1) {
				System.out.println("할인율 : 10%");
				System.out.println("할인액 : " + (int)(pay*0.1) + "원");
				System.out.println("지불액 : " + (pay - (int)(pay*0.1)) + "원");
			}else {
				System.out.println("할인율 : 5%");
				System.out.println("할인액 : " + (int)(pay*0.05) + "원");
				System.out.println("지불액 : " + (pay - (int)(pay*0.05)) + "원");
			}
		}else
			System.out.print("잘못 입력하였습니다. 종료합니다.");
		
		sc.close();
	}

}
