package sec01;

import java.util.ArrayList;

public interface IMemberDAO {
	
	// 회원가입
	void save(MemberVO member);                  
	
	// 로그인
    MemberVO login(String memId, String memPwd); 
    
    // 내 정보 조회
    MemberVO memberFindById(String memId);       
    
    // 전체 회원 조회
    ArrayList<MemberVO> memberFindAll();         
	
}
