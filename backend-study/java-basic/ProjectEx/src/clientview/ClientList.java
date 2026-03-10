package clientview;

import java.util.ArrayList;

import controller.ClientController;
import model.client.ClientDTO;

public class ClientList {
	ClientController controller = ClientController.getinstance();
	
	public void getAllClient() {
		controller.clientList();
	}
	
	public static void showAllClient(ArrayList<ClientDTO> clientList) {
		System.out.println("\n*******************************");
		System.out.println("회원 정보 조회");
		System.out.println("*********************************");
		
		System.out.println("회원번호\t이름\t비밀번호\t\t전화번호\t\t주소\t\t생년월일\t취미\t성별");
		System.out.println("--------------------------------------------------------");
		
		for(ClientDTO dto : clientList) {
			System.out.println(dto);
		}
	}
}
