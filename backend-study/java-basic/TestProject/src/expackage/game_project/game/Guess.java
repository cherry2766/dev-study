package expackage.game_project.game;

import java.util.Random;
import java.util.Scanner;

public class Guess {
	private final Scanner sc;
	private int randomNum;
	int num;
	
	public Guess(Scanner sc) {
		this.sc = sc;
	}

	public void gameGuess() {
		System.out.println("================================");
		System.out.println("         숫자 알아맞히기 게임        ");
		System.out.println("---------------------------------");
		System.out.println("어떤 숫자일까요? 알아 맞혀보세요:) (1~10)");
		System.out.println("---------------------------------");

		random();

		System.out.print("숫자 입력 : ");
		while (true) {
			checkNum();

			if (num == randomNum) {
				System.out.println("드디어 맞혔습니다~ 나의 숫자는 " + randomNum + "입니다!");
				break;
			} else {
				System.out.print("아닙니다! 다시 맞혀보세요:) 다시 입력 : ");
				continue;
			}
		}
		System.out.println("***********************************");
	}

	public void random() {
		Random nums = new Random();
		randomNum = nums.nextInt(10) + 1;
	}
	
	public void checkNum() {
		while (true) {
			try {
				num = sc.nextInt();
				if (num < 1 || num > 10) {
					System.out.print("잘못 입력했습니다. 다시 입력하세요 : ");
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
