package clientview;

import java.sql.Date;
import java.util.Scanner;

import controller.ClientController;
import model.client.ClientDTO;

public class ClientInsert {
	ClientController controller = ClientController.getinstance();

	public void insert(Scanner sc) {
		String clientNo, clientName, clientPhone, clientAddress, clientHobby, clientGender, clientPassword;
		Date clientBirth;

		System.out.println("\n*************************");
		System.out.println("회원 등록");
		System.out.println("***************************");

		System.out.print("회원번호 입력 : ");
		clientNo = sc.nextLine();

		System.out.print("이름 입력 : ");
		clientName = sc.nextLine();

		System.out.print("비밀번호 입력 : ");
		clientPassword = sc.nextLine();

		System.out.print("전화번호 입력 : ");
		clientPhone = sc.nextLine();

		System.out.print("주소 입력 : ");
		clientAddress = sc.nextLine();

		System.out.print("생년월일 입력 : ");
		String birth = sc.nextLine();
		clientBirth = Date.valueOf(birth);

		System.out.print("취미 입력 : ");
		clientHobby = sc.nextLine();

		System.out.print("성별 입력 : ");
		clientGender = sc.nextLine();
		System.out.println("***************************");

		controller.insert(new ClientDTO(clientNo, clientName, clientPassword, clientPhone, clientAddress, clientBirth,
				clientHobby, clientGender));
	}
}
