package Week5.package2;

import Week5.role.Role;
import java.util.List;

public interface MemberRepository {
    void save(Role member);
    Role findByName(String name);
    Role findName(String name);
    List<Role> findAll();
}