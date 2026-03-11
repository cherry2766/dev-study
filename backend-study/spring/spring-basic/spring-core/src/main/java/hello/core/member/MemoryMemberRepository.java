package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 구현체
// 데이터 조회 !!!!!!
@Component
public class MemoryMemberRepository implements MemberRepository {

    // 회원Id -> 회원 객체
    /*
     * 1L -> new Member(1L, "userA", Grade.VIP)
     * 2L -> new Member(2L, "userB", Grade.BASIC)
     * */
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    // member를 저장
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    // memberId로 회원 조회
    public Member findById(Long memberId) {
        // store에서 memberId를 key로 찾아서 value를 꺼냄
        return store.get(memberId);
    }

}
