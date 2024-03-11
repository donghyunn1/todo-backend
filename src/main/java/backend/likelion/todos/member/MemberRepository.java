package backend.likelion.todos.member;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    private final Map<Long, Member> members = new HashMap<>();
    private Long id = 1L;

    // 멤버를 저장소에 저장하고 저장된 멤버를 반환합니다.
    public Member save(Member member) {
        member.setId(id);
        members.put(id,member);
        return member;
    }

    // 주어진 id에 해당하는 멤버를 찾아 Optional로 반환합니다.
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(members.get(id));
    }

    // 주어진 username과 일치하는 멤버를 찾아 Optional로 반환합니다.
    public Optional<Member> findByUsername(String username) {
        return members.values()
                .stream()
                .filter(it -> it.getUsername().equals(username))
                .findAny();
    }

    // 저장소의 모든 멤버를 제거합니다.
    public void clear() {
        members.clear();
    }
}
