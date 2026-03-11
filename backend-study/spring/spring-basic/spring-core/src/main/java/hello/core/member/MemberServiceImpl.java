package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 회원 기능을 실제로 동작하게 만드는 클래스
@Component
public class MemberServiceImpl implements MemberService{

    // 회원 저장/조회는 Repository에게 맡김
    private final MemberRepository memberRepository;


    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    // 회원 가입 기능
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    // 회원 조회 기능
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
