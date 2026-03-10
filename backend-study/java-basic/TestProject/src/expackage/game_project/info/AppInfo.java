package expackage.game_project.info;

import java.util.Scanner;
import expackage.game_project.game.GaBaBo;
import expackage.game_project.game.Guess;

public class AppInfo {
	private final Scanner sc;
	private final GaBaBo game1;
	private final Guess game2;

	public AppInfo(Scanner sc) {
		this.sc = sc;
		this.game1 = new GaBaBo(sc);
		this.game2 = new Guess(sc);
	}

	public void showAppInfo() {
		System.out.println("***********************************");
		System.out.println("          애플리케이션 정보            ");
		System.out.println("-----------------------------------");
		System.out.println("제목 : ★★게임");
		System.out.println("제작자 : 홍길동");
		System.out.println("내용 : 가위바위보 게임/숫자 알아맞히기 게임");
		System.out.println("***********************************");
	}

	public void startGaBaBo() {
		System.out.println("***********************************");
		System.out.println("       ★★ 가위바위보 게임 ★★         ");
		System.out.println("       가위 바위 보 게임 입니다        ");
		System.out.println("***********************************");
		if (confirmStart()) {
			game1.gameGaBaBo();
		} else {
			System.out.println("메뉴로 돌아갑니다.");
		}

	}

	public void startGuess() {
		System.out.println("***********************************");
		System.out.println("       ★★ 숫자 알아맞히기 게임 ★★     ");
		System.out.println("        숫자 알아맞히기 게임 입니다      ");
		System.out.println("***********************************");
		if (confirmStart()) {
			game2.gameGuess();
		} else {
			System.out.println("메뉴로 돌아갑니다.");
		}
	}
	
	private boolean confirmStart() {
	    System.out.print("게임을 시작하시겠습니까? (y/n 입력)");
	    char check = sc.next().charAt(0);
	    return check == 'y';
	}
}
