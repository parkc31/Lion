package class4.role;

import class4.policy.AssignmentPolicy;

public abstract class AbstractMember {
    // 부모 클래스의 필드는 private으로 유지
    private String name;
    private String major;
    private int generation;
    private String part;

    // 생성자를 통해 필드 초기화
    public AbstractMember(String name, String major, int generation, String part) {
        this.name = name;
        this.major = major;
        this.generation = generation;
        this.part = part;
    }

    // 각 역할에 맞는 정책 객체를 반환할 추상 메서드
    protected abstract AssignmentPolicy getPolicy();

    // 역할의 이름("아기사자" 또는 "운영진")을 반환할 추상 메서드
    public abstract String getRoleName();

    // 역할별 상세 정보(학번 또는 직책)를 반환할 추상 메서드
    protected abstract String getRoleDetails();

    // 과제 제출 여부는 정책 객체에 위임하여 판단 (Main에 로직을 두지 않음)
    public boolean canSubmitAssignment() {
        return getPolicy().Submit();
    }

    // 결과 화면 양식에 맞춰 정보 출력하는 공통 메서드
    public void printInfo() {
        System.out.println("🎭 역할: " + getRoleName());
        System.out.printf("👤 이름: %s | 🎓 전공: %s | 📌 기수: %d | 💻 파트: %s\n",
                name, major, generation, part);
        System.out.println(getRoleDetails());
        System.out.println("📝 과제 제출 가능 여부: " + (canSubmitAssignment() ? "✅ 가능" : "❌ 불가능"));
        System.out.println();
    }

    public Object getName() {
        return name;
    }

    public Object getGeneration() {
        return generation;
    }
}
