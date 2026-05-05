package Week4.class4.role;

import Week4.class4.policy.AssignmentPolicy;
import Week4.class4.policy.StaffPolicy;

public class Staff extends AbstractMember {
    private String position; // 운영진 전용 속성 (직책)

    public Staff(String name, String major, int generation, String part, String position) {
        super(name, major, generation, part); // 부모 클래스의 생성자 호출
        this.position = position;
    }

    @Override
    protected AssignmentPolicy getPolicy() {
        return new StaffPolicy(); // 운영진 정책 반환
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    protected String getRoleDetails() {
        return "⭐ 직책: " + position;
    }
}
