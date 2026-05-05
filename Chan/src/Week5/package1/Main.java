package Week5.package1;

import Week5.role.Role;import Week5.role.Lion;import Week5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Main에서는 오직 Service만 생성해서 사용합니다. Repository는 모릅니다.
        MemberService memberService = new MemberService();

        while (true) {
            System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 1: 레이어 분리) ===== 🦁");
            System.out.println("1. ✨ 멤버 등록");
            System.out.println("2. 📋 전체 멤버 조회");
            System.out.println("3. 🔍 이름으로 검색");
            System.out.println("4. 🚪 종료");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // 줄바꿈 문자 제거

            if (choice == 1) {
                System.out.println("\n👤 역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleType = scanner.nextInt();
                scanner.nextLine();

                System.out.println("\n📝 정보 입력");
                System.out.print("이름: ");
                String name = scanner.nextLine();
                System.out.print("전공: ");
                String major = scanner.nextLine();
                System.out.print("기수: ");
                int generation = scanner.nextInt();
                scanner.nextLine();
                System.out.print("파트: ");
                String part = scanner.nextLine();
                System.out.print("학번: ");
                String studentId = scanner.nextLine();

                Role newMember;
                if (roleType == 1) {
                    newMember = new Lion(name, major, generation, part, studentId);
                } else {
                    newMember = new Staff(name, major, generation, part, studentId);
                }

                // 서비스에게 비즈니스 로직(저장)을 위임
                boolean isSuccess = memberService.registerMember(newMember);

                if (isSuccess) {
                    System.out.println("\n✅ 등록 완료: " + name);
                } else {
                    System.out.println("\n❌ 이미 존재하는 이름입니다.");
                }

            } else if (choice == 2) {
                System.out.println("\n📋 ===== 전체 멤버 목록 =====");
                List<Role> members = memberService.getAllMembers();
                for (Role member : members) {
                    member.printInfo();
                }

            } else if (choice == 3) {
                System.out.print("\n🔍 검색할 이름: ");
                String searchName = scanner.nextLine();

                // 서비스에게 검색 위임
                Role foundMember = memberService.findMemberByName(searchName);
                if (foundMember == null) {
                    System.out.println("\n해당 이름의 멤버를 찾을 수 없습니다.");
                }

            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}
