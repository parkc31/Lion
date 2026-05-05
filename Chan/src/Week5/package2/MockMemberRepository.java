package Week5.package2;

import Week5.role.Role;
import java.util.ArrayList;
import java.util.List;

public class MockMemberRepository implements MemberRepository {

    @Override
    public void save(Role member) {
        System.out.println("[Mock] 가짜 저장소: 실제 메모리에 저장하지 않습니다. (" + member.getName() + ")");
    }

    @Override
    public Role findByName(String name) {
        System.out.println("[Mock] 가짜 저장소: 찾기 기능을 무시하고 null을 반환합니다.");
        return null; // 과제 규격에 맞게 더미 응답을 하도록 설정
    }

    @Override
    public Role findName(String name) {
        return null;
    }

    @Override
    public List<Role> findAll() {
        System.out.println("[Mock] 가짜 저장소: 빈 리스트를 반환합니다.\n");
        return new ArrayList<>();
    }
}