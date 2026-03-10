package clientview;

import java.util.Scanner;

import controller.ClientController;

public class ClientDelete {
	ClientController controller = ClientController.getinstance();

	public void delete(Scanner sc) {
		String clinetNo;

		System.out.println("\n*************************");
		System.out.println("회원정보 삭제");
		System.out.println("***************************");

		ClientList list = new ClientList();
		list.getAllClient();

		System.out.print("삭제할 회원번호 입력 : ");
		clinetNo = sc.nextLine();
		System.out.println("***************************");

		controller.delete(clinetNo);
	}

}
