package Week5.package1;

import Week5.role.Role;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {
    // 실제 데이터가 저장되는 메모리 공간
    private final List<Role> members = new ArrayList<>();

    // 멤버 저장 기능
    public void save(Role member) {
        members.add(member);
    }

    // 이름으로 멤버 검색 기능
    public Role findByName(String name) {
        for (Role member : members) {
            if (member.getName().equals(name)) {
                System.out.println("\n🎯 ===== 검색 결과 =====");
                member.printInfo();
                return member;
            }
        }
        return null; // 못 찾으면 null 반환
    }

    // 전체 멤버 조회 기능
    public List<Role> findAll() {
        return members;
    }

    // 이름 중복 확인 기능
    public boolean existsByName(String name) {
        return findByName(name) != null;
    }
}