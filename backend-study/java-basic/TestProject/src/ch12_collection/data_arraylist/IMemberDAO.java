package ch12_collection.data_arraylist;

import java.util.List;

//컨트롤러와 DAO의 중간자 역할을 진행함
public interface IMemberDAO {
	// 추상 메서드

	// 회원등록 : 1명의 회원 정보를 받아서 DB에 저장하고 종료, 반환값 없음
	public void insertMember(MemberDTO dto);

	// 회원정보 삭제 : 회원의 아이디(memId)를 전달받아서
	// DB에서 해당되는 회원 찾아서 삭제 종료, 반환값 없음
	public void deleteMember(String memId);

	// 전체 회원정보 조회
	// DB(회원테이블)에서 전체 회원 정보(ArrayList)를 반환
	// 회원 여러명 : MemberDTO 타입의 인스턴스 여러개 저장: 
	// ArrayList(배열은 처음부터 크기가 고정되어야 함 -> 부적절, 가변배열처럼 사용가능한 ArrayList)
	public List<MemberDTO> getAllMember();
	
	// 한명 회원 정보 조회
	// memId를 전달 받아서 DB에서 검색 후 회원 한명의 정보(MemberDTO)를 반환하는 메서드
	public MemberDTO searchMember(String memId);
	
	// 회원정보 수정
	// memId를 포함하는 수정 정보(MemberDTO)를 전달 받아서 DB에서 회원 정보 수정 후 종료, 반환값 없음
	public void updateMember(MemberDTO dto);
}
