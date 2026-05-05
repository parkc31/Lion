package Week5.package2;

import Week5.role.Role;
import java.util.List;

public class MemberService {
    // 💡 핵심 1: 구체적인 클래스가 아닌 인터페이스에 의존!
    private final MemberRepository repository;

    // 💡 핵심 2: DI (의존성 주입) - 외부에서 repository를 밀어 넣어줌
    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public boolean registerMember(Role member) {
        // 중복 검사 로직
        if (repository.findName(member.getName()) != null) {
            System.out.println("❌ 이미 존재하는 이름입니다.");
            return false;
        }
        repository.save(member);
        return true;
    }

    public Role findMemberByName(String name) {
        return repository.findByName(name);
    }

    public List<Role> getAllMembers() {
        return repository.findAll();
    }
}