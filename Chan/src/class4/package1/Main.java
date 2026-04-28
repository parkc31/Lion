package class4.package1;

import class4.role.AbstractMember;
import class4.role.Lion;
import class4.role.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 모든 멤버를 저장할 리스트 생성
        List<AbstractMember> memberList = new ArrayList<>();

        while (true) {
            System.out.println("--------- 🦁 멤버 관리 시스템 ---------");
            System.out.println(" 1. 멤버 등록 \n 2. 전체 조회 \n 3. 이름 검색 \n 4. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기
            System.out.println("");


            if (choice == 1) { // 등록 기능
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = sc.nextInt();
                sc.nextLine();

                System.out.print("👤 이름: ");
                String name = sc.nextLine();

                // 중복 체크 로직
                boolean isDuplicate = false;
                for (AbstractMember member : memberList) {
                    if (member.getName().equals(name)) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (isDuplicate) {
                    System.out.println("❌ 이미 존재하는 이름입니다. 등록을 거부합니다.");
                } else {
                    // 정보 입력 후 객체 생성 및 리스트 추가
                    System.out.print("🎓 전공: "); String major = sc.nextLine();
                    System.out.print("📌 기수: "); int gen = sc.nextInt(); sc.nextLine();
                    System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): "); String part = sc.nextLine();
                    System.out.print("🆔 학번: "); String StudentId = sc.nextLine();


                    if (roleChoice == 1) {
                        memberList.add(new Lion(name, major, gen, part,StudentId));
                    } else {
                        memberList.add(new Staff(name, major, gen, part, null));
                    }
                    System.out.println("✅ 등록 완료!: \n" + name);
                }

            } else if (choice == 2) { // 전체 조회

                if (memberList.isEmpty()) {
                    System.out.println("⚠️ 아직 등록된 멤버가 없습니다. 멤버를 먼저 등록해 주세요!\n");
                } else {
                    System.out.println("\n=== 전체 멤버 목록 ===");
                    for (AbstractMember member : memberList) {
                        member.printInfo(); // 다형성 활용
                    }
                    System.out.println("📊 총" + memberList.size() + "명\n");}


            } else if (choice == 3) { // 이름 검색
                System.out.print("검색할 이름: ");
                String searchName = sc.nextLine();
                boolean found = false;

                for (AbstractMember member : memberList) {
                    if (member.getName().equals(searchName)) {
                        member.printInfo();
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("🔍 해당 멤버를 찾을 수 없습니다.");

            } else if (choice == 4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}