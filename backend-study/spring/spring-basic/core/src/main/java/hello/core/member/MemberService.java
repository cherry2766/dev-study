package hello.core.member;

// 회원 서비스는 이런 기능이 있어야 한다
// 기능 제공!!!!!!!!!!
public interface MemberService {

    // 회원 가입
    void join(Member member);

    // 회원 조회
    Member findMember(Long memberId);
}
