package ch12_collection.data_arraylist;

import java.util.ArrayList;
import java.util.List;

public class MemberDAO implements IMemberDAO {
	// DB 대신 사용할 저장소 구성 : DB 사용시에는 회원 정보 집합을 표현할 때 사용
	private List<MemberDTO> listData = new ArrayList<>();

	@Override
	public void insertMember(MemberDTO dto) {
		// dto 활용 DB에 저장하는 코드(arrayList에 저장함)
		// 회원가입시 유일하게 구별가능한 data는 중복되면 안됨 - 전달된 dto의 memId값이 이미 저장된 객체들의 memId와 중복되는 객체가
		// 있는지 확인
		// List.stream() : 컬렉션에 저장되어 있는 엘리먼트들을 순회하여 전달된 코드를 처리, Stream<T> 객체가 반환됨
		// Stream.filter(조건) : 반환된 stream 객체에 대해 조건 연산 진행 가능한 메서드
		// filter(item->item을 이용한 조건식) ex.filter(member ->
		// member.getMemId().equals(dto.getMemId())
		// findFirst() : filter 조건에 맞는 객체가 처음 찾아지면 객체 반환(Optional 객체로 반환)
		// Optional.orElse(null); : 조건에 맞는 객체가 없으면 null 반환

		String tmpId = dto.getMemId();
		MemberDTO optDto = listData.stream().filter(member -> member.getMemId().equals(tmpId)).findFirst().orElse(null);
		if (optDto != null) {
			System.out.println("회원가입 실패 : 동일 ID의 회원이 있습니다");
		} else {
			listData.add(dto);
			System.out.println("회원가입 성공");
		}
	}

	@Override
	public void deleteMember(String memId) {
		// memId 활용해서 DB에서 삭제를 위한 코드
		// arrayList에서 memId 값과 동일한 id를 가지고 있는 객체를 찾음
		MemberDTO delDto = listData.stream().filter(member -> member.getMemId().equals(memId)).findFirst().orElse(null);
		if (delDto != null) {
			listData.remove(delDto);
			System.out.println("회원정보가 영구 삭제되었습니다");
		} else {
			System.out.println("해당 id의 회원이 없습니다");
		}

	}

	@Override
	public List<MemberDTO> getAllMember() {
		// 모든 회원 정보 반환받아서 MemberDTO에 넣고 ArrayList에 포함해서 리턴
		return listData;
	}

	@Override
	public MemberDTO searchMember(String memId) {
		MemberDTO searDto = listData.stream().filter(member -> member.getMemId().equals(memId)).findFirst()
				.orElse(null);
		return searDto;

	}

	@Override
	public void updateMember(MemberDTO dto) {
		// MemberDTO 활용해서 ArrayList에서 수정
		// 해당 id의 객체 참조를 추출
		MemberDTO updateDto = listData.stream().filter(member -> member.getMemId().equals(dto.getMemId())).findFirst()
				.orElse(null);
		if (updateDto != null) {
			int idx = listData.indexOf(updateDto); // 수정할 객체의 index값을 반환
			listData.set(idx, dto);
			System.out.println("회원 정보 수정이 완료되었습니다");
		} else {
			System.out.println("회원 정보를 찾을 수 없습니다");
		}

	}

}
