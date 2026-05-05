package Week4.class4.package2;

import Week4.class4.role.AbstractMember;
import Week4.class4.role.Lion;
import Week4.class4.role.Staff;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 1. 모든 멤버를 저장할 리스트
        List<AbstractMember> memberList = new ArrayList<>();
        // 🚨 2. 파트별 멤버를 저장할 맵 (Key: 파트명, Value: 해당 파트 멤버 리스트)
        Map<String, List<AbstractMember>> memberMap = new HashMap<>();

        while (true) {
            System.out.println("--------- 🦁 멤버 관리 시스템 (Step 2) ---------");
            System.out.println(" 1. 멤버 등록 \n 2. 전체 조회 \n 3. 이름 검색 \n 4. 파트별 조회 \n 5. 종료");
            System.out.print("선택: ");
            int choice = sc.nextInt();
            sc.nextLine();
            System.out.println("");

            if (choice == 1) { // 등록 기능
                System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
                int roleChoice = sc.nextInt();
                sc.nextLine();

                System.out.print("👤 이름: ");
                String name = sc.nextLine();

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
                    System.out.print("🎓 전공: "); String major = sc.nextLine();
                    System.out.print("📌 기수: "); int gen = sc.nextInt(); sc.nextLine();
                    System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): "); String part = sc.nextLine();

                    AbstractMember newMember;
                    if (roleChoice == 1) {
                        System.out.print("🆔 학번: "); String studentId = sc.nextLine();
                        newMember = new Lion(name, major, gen, part, studentId);
                    } else {
                        newMember = new Staff(name, major, gen, part, "운영진");
                    }

                    memberList.add(newMember);

                    // 🚨 2. Map에 파트별로 추가
                    // 만약 이 파트가 처음 등록되는 파트라면 리스트를 새로 생성
                    if (!memberMap.containsKey(part)) {
                        memberMap.put(part, new ArrayList<>());
                    }
                    // 해당 파트 리스트에 멤버 추가
                    memberMap.get(part).add(newMember);

                    System.out.println("✅ 등록 완료!: " + name);
                    System.out.println("");
                }

            } else if (choice == 2) { // 전체 조회
                if (memberList.isEmpty()) {
                    System.out.println("⚠️ 아직 등록된 멤버가 없습니다.\n");
                } else {
                    System.out.println("\n=== 전체 멤버 목록 ===");
                    for (AbstractMember member : memberList) {
                        member.printInfo();
                    }
                    System.out.println("📊 총 " + memberList.size() + "명\n");
                }

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
                if (memberMap.isEmpty()) {
                    System.out.println("⚠️ 등록된 파트가 없습니다.");
                } else {
                    System.out.println("등록된 파트: " + memberMap.keySet());
                    System.out.print("조회할 파트명을 입력하세요: ");
                    String searchPart = sc.nextLine();

                    if (memberMap.containsKey(searchPart)) {
                        System.out.println("\n✨ [" + searchPart + " 파트 멤버 목록]");
                        List<AbstractMember> partList = memberMap.get(searchPart);

                        for (int i = 0; i < partList.size(); i++) {
                            AbstractMember member = partList.get(i);
                            System.out.printf("%d. %s (%s) - %d기\n",
                                    i + 1,
                                    member.getName(),
                                    member.getRoleName(),
                                    member.getGeneration());
                        }

                        System.out.println("");
                    }
                }

            } else if (choice == 5) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }
}