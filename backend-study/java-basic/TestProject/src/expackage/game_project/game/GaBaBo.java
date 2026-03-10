package expackage.game_project.game;

import java.util.Random;
import java.util.Scanner;

public class GaBaBo {
	private final Random nums = new Random();
	private final Scanner sc;
	private int randomNum;
	private String selected;
	int num;

	public GaBaBo(Scanner sc) {
		this.sc = sc;
	}

	public void gameGaBaBo() {
		System.out.println("================================");
		System.out.println("         가위바위보 게임          ");
		System.out.println("가위바위보 게임 : 1.가위, 2.바위, 3.보");

		while (true) {
			random();

			System.out.println("================================");
			System.out.print("번호 입력 : ");

			checkNum();

			if ((num == 1 && randomNum == 3) || 
				(num == 2 && randomNum == 1) || 
				(num == 3 && randomNum == 2)) {
				System.out.println("당신이 이겼습니다!!");
			} else if (num == randomNum) {
				System.out.println("무승부!!");
			} else {
				System.out.println("졌습니다ㅠㅠ");
			}
			System.out.println("컴퓨터는 " + selected + "입니다.");

			System.out.print("계속하시겠습니다? (y/n) : ");
			char answer = sc.next().charAt(0);
			if (answer != 'y') {
				System.out.println("게임을 종료합니다.");
				break;
			}
		}

	}

	public void random() {
		randomNum = nums.nextInt(3) + 1;
		switch (randomNum) {
		case 1:
			selected = "가위";
			break;
		case 2:
			selected = "바위";
			break;
		case 3:
			selected = "보";
			break;
		}
	}

	public void checkNum() {
		while (true) {
			try {
				num = sc.nextInt();
				if (num < 1 || num > 3) {
					System.out.print("잘못 입력하였습니다.(1.가위, 2.바위, 3.보) 다시 입력 : ");
					continue;
				}
				break;
			} catch (Exception e) {
				System.out.print("숫자만 입력하세요. 다시 입력 : ");
				sc.nextLine(); // 잘못된 입력 버림
			}
		}
	}

}
