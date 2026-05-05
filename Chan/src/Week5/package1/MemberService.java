package Week5.package1;

import Week5.role.Role;

import java.util.List;

public class MemberService {

    // 💡 Step 1의 핵심: 서비스가 리포지토리(저장소)를 직접 생성합니다. (강한 결합)
    private final MemberRepository repository = new MemberRepository();

    // 회원 등록 로직
    public boolean registerMember(Role member) {
        // 비즈니스 로직: 중복 이름 검사
        if (repository.existsByName(member.getName())) {
            return false; // 등록 실패 (중복)
        }

        // 저장소에 저장 명령
        repository.save(member);
        return true; // 등록 성공
    }

    // 이름으로 회원 찾기
    public Role findMemberByName(String name) {
        return repository.findByName(name);
    }

    // 전체 회원 목록 가져오기
    public List<Role> getAllMembers() {
        return repository.findAll();
    }
}