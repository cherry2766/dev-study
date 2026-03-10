package clientview;

import java.util.Scanner;

import controller.ClientController;
import model.client.ClientDTO;

public class ClientLogin {
	ClientController controller = ClientController.getinstance();
	String clientNo, clientPassword;

	public boolean login(Scanner sc) {

		System.out.println("\n*************************");
		System.out.println("로그인 정보 입력");
		System.out.println("***************************");

		System.out.print("회원번호 입력 : ");
		clientNo = sc.nextLine();

		System.out.print("비빌번호 입력 : ");
		clientPassword = sc.nextLine();

		ClientDTO dto = new ClientDTO();

		return controller.login(clientNo, clientPassword);
	}

	public String getLoginClientNo() {
		return clientNo;
	}
}
