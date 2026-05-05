package Week5.package2;

import Week5.role.Lion;
import Week5.role.Role;
import Week5.role.Staff;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. 어떤 저장소를 쓸지 선택 (다형성 체험)
        System.out.println("🔧 저장소를 선택하세요:");
        System.out.println("1. MemoryMemberRepository (실제 저장)");
        System.out.println("2. MockMemberRepository (더미 데이터)");
        System.out.print("선택: ");
        int repoChoice = scanner.nextInt();
        scanner.nextLine(); // 버퍼 비우기

        MemberRepository repository; // 인터페이스 타입으로 선언

        if (repoChoice == 1) {
            repository = new MemoryMemberRepository();
        } else {
            repository = new MockMemberRepository();
        }

        // 2. DI (의존성 주입): 생성된 저장소를 Service에 밀어 넣어줌!
        MemberService memberService = new MemberService(repository);

        System.out.println("\n🦁 ===== 멋사 멤버 관리 시스템 (Step 2: DI 적용) ===== 🦁");

        while (true) {
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
                    System.out.println();
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
                    System.out.println("\n해당 이름의 멤버를 찾을 수 없습니다.\n");
                }

            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
        scanner.close();
    }
}
