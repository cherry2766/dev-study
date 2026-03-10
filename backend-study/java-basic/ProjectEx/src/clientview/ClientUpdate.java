package clientview;

import java.sql.Date;
import java.util.Scanner;

import controller.ClientController;
import model.client.ClientDTO;

public class ClientUpdate {
	ClientController controller = ClientController.getinstance();
	
	public void update(Scanner sc) {
		String clientNo, clientName, clientPhone, clientAddress, clientHobby, clientGender, clientPassword;
		Date clientBirth;

		System.out.println("\n*************************");
		System.out.println("회원 정보 수정");
		System.out.println("***************************");
		
		ClientList list = new ClientList();
		list.getAllClient();

		System.out.print("수정할 회원번호 입력 : ");
		clientNo = sc.nextLine();

		System.out.print("이름 입력 : ");
		clientName = sc.nextLine();

		System.out.print("전화번호 입력 : ");
		clientPhone = sc.nextLine();

		System.out.print("주소 입력 : ");
		clientAddress = sc.nextLine();

		System.out.print("생년월일 입력 : ");
		String birth = sc.nextLine();
		clientBirth = Date.valueOf(birth);

		System.out.print("취미 입력 : ");
		clientHobby = sc.nextLine();

		System.out.println("***************************");

		controller.update(new ClientDTO(clientNo, clientName, clientPhone, clientAddress, clientBirth,
				clientHobby));
	}
}
