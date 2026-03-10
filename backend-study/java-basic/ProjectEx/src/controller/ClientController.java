package controller;

import java.util.ArrayList;

import clientview.ClientList;
import model.client.ClientDAO;
import model.client.ClientDTO;
import model.client.IClientDAO;
import util.ResultView;

public class ClientController {
	private static ClientController instance = new ClientController();
	IClientDAO dao = new ClientDAO();

	private ClientController() {

	}

	public static ClientController getinstance() {
		return instance;
	}

	public boolean login(String no, String pass) {
		try {
			ClientDTO dto = new ClientDTO();
			dto.setClientNo(no);
			dto.setClientPassword(pass);
			return dao.login(dto);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public void insert(ClientDTO dto) {
		try {
			if (dao.insert(dto)) {
				ResultView.succMsg("회원 가입이 완료되었습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("오류가 발생했습니다");
		}
	}

	public void clientList() {
		try {
			ArrayList<ClientDTO> clientList = dao.getAllClient();
			if (clientList.size() != 0) {
				ClientList.showAllClient(clientList);
			} else {
				ResultView.succMsg("검색 결과가 없습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("오류가 발생했습니다");
		}
	}

	public void update(ClientDTO newDto) {
		try {
			ClientDTO dto = new ClientDTO();

			dto.setClientNo(newDto.getClientNo());
			dto.setClientName(newDto.getClientName());
			dto.setClientPassword(newDto.getClientPassword());
			dto.setClientPhone(newDto.getClientPhone());
			dto.setClientAddress(newDto.getClientAddress());
			dto.setClientBirth(newDto.getClientBirth());
			dto.setClientHobby(newDto.getClientHobby());
			dto.setClientGender(newDto.getClientGender());

			if (dao.update(dto)) {
				ResultView.succMsg("회원 정보 수정이 완료되었습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("오류가 발생했습니다");
		}
	}

	public void delete(String clientNo) {
		try {
			ClientDTO dto = new ClientDTO();

			dto.setClientNo(clientNo);

			if (dao.delete(dto)) {
				ResultView.succMsg("회원 정보를 삭제하였습니다");
			} else {
				ResultView.succMsg("해당하는 회원번호의 회원이 없습니다");
			}

		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("오류가 발생했습니다");
		}
	}
}
