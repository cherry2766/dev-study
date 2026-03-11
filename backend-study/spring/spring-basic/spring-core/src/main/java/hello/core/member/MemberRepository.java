package hello.core.member;

// 회원 저장소가 어떤 기능을 가져야 하는지 정의한 인터페이스(설계도)
public interface MemberRepository {

    // 회원 저장
    void save(Member member);

    // 회원의 아이디로 회원을 찾는 기능
    Member findById(Long memberId);

}
