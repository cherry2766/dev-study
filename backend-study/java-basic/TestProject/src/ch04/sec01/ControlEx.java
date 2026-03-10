package ch04.sec01;
import java.util.Scanner;

public class ControlEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int itemNum, num, pay, totalPay, discount;
		String name;

		System.out.println("******* 상품 정보 *******");
		System.out.println("1 노트북 : 1,200,000 원");
		System.out.println("2 디지털카메라 : 400,000 원");
		System.out.println("***********************");
		System.out.print("상품번호 입력 : ");
		itemNum = sc.nextInt();

		if(itemNum == 1 || itemNum == 2) {
			System.out.print("주문 수량 입력 : ");
			num = sc.nextInt();

			if(itemNum == 1) {
				name = "노트북";
				pay = 1200000;
			} else { 
				name = "디지털카메라";
				pay = 400000;
			}
	
			totalPay = num * pay;
		
			if(totalPay >= 1000000)
				discount = (int)(totalPay * 0.1);
			else if(totalPay >= 500000)
				discount = (int)(totalPay * 0.05);
			else
				discount = 0; 
		
			System.out.println("******* 주문 내용 *******");
			System.out.println("상품명 : " + name);
			System.out.println("가격 : " + pay + " 원");
			System.out.println("주문 수량 : " + num + " 개");
			System.out.println("주문액 : " + totalPay + " 원");
			System.out.println("할인액 : " + discount + " 원");
			System.out.println("총지불액 : " + (totalPay - discount) + " 원");

		} else {
			System.out.println("잘못 입력하였습니다. 종료합니다.");
		}

		sc.close();
	  	}
}
