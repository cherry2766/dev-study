package sec06.client;

import java.util.ArrayList;

public interface IClientDAO {

	// 회원 등록
	public void insertClient(ClientDTO dto);

	// 전체 회원 조회
	public ArrayList<ClientDTO> listClient();

	// 회원 상세 조회
	public ClientDTO detailClient(String clientNo);

	// 회원 수정
	public void updateClient(ClientDTO dto);

	// 회원 삭제
	public void deleteClient(String clientNo);

	// 로그인
	public boolean login(String clientNo, String clientPassword);

}
