package class3.role;

import class3.policy.AssignmentPolicy;
import class3.policy.LionPolicy;

public class Lion extends AbstractMember{
    private String StudentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part); // 부모 클래스의 생성자 호출
        this.StudentId = studentId;
    }

    @Override
    protected AssignmentPolicy getPolicy() {
        return new LionPolicy(); // 아기사자 정책 반환
    }

    @Override
    protected String getRoleName() {
        return "아기사자";
    }

    @Override
    protected String getRoleDetails() {
        return "🆔 학번: " + StudentId;
    }
}
