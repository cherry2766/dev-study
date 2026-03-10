package hello.core.member;

// 회원 기능을 실제로 동작하게 만드는 클래스
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
}
