package ch04.sec02;
import java.util.Scanner;

public class doWhile2 {

	public static void main(String[] args) {
		// do~while 예제
		Scanner sc = new Scanner(System.in);
		int input;
		String answer = "";
		
		System.out.println("###########과정 안내 프로그램###########");
		
		do {
			System.out.print("\n1~4번호 입력 : ");
			input = sc.nextInt();
			
			switch(input) {
			case 1: 
				System.out.println("Java 프로그래밍\n"); 
				break;
			case 2:
                System.out.println("데이터 베이스\n");
                break;
            case 3:
                System.out.println("알고리즘\n");
                break;
            case 4:
                System.out.println("AI\n");
                break;
            default:
            	System.out.println("잘못 입력하였습니다\n");
			}
			
			System.out.print("\n계속 확인하시겠습니까?(y/n입력)");
			answer = sc.next();
			
		}while(answer.contentEquals("y"));
		System.out.println("종료합니다");
		sc.close();
	}

}
