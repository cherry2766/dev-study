package expackage.game_project.start;

import java.util.Scanner;
import expackage.game_project.info.AppInfo;

public class AppStart {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AppInfo info = new AppInfo(sc);
		boolean running = true;

		System.out.println("***********************************");
		System.out.println("    ★★ 게임에 오신 것을 환영합니다 ★★");
		System.out.println("***********************************");

		while (running) {
			System.out.println("               메뉴                 ");
			System.out.println("-----------------------------------");
			System.out.println("1. 애플리케이션 정보");
			System.out.println("2. 가위바위보 게임");
			System.out.println("3. 숫자 알아맞히기 게임");
			System.out.println("4. 종료");
			System.out.println("-----------------------------------");

			System.out.print("메뉴 번호 입력 : ");
			int num = checkNum(sc);

			switch (num) {
			case 1:
				info.showAppInfo();
				break;// 이건 info 패키지
			case 2:
				info.startGaBaBo();
				break;// 이건 game 패키지의 GaBoBo
			case 3:
				info.startGuess();
				break; // 이건 game 패키지의 Guess
			case 4:
				running = false;
				break;
			}
		}

		System.out.println("***********************************");
		System.out.println("종료합니다!!");
		System.out.println("***********************************");

		sc.close();

	}

	public static int checkNum(Scanner sc) {
		while (true) {
			try {
				int num = sc.nextInt();
				if (num < 1 || num > 4) {
					System.out.print("잘못 입력하였습니다. 다시 입력 : ");
					continue;
				}

				return num;
			} catch (Exception e) {
				System.out.print("숫자만 입력하세요. 다시 입력 : ");
				sc.nextLine(); // 잘못된 입력 버림
			}
		}
	}
}
