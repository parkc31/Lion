package Week4.class4;

import Week4.class4.role.AbstractMember;
import Week4.class4.role.Lion;
import Week4.class4.role.Staff;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 아기사자 정보 입력
        System.out.println("====== 🦁 아기사자 정보 입력 ======");
        System.out.print("👤 이름: ");
        String lionname = sc.nextLine();
        System.out.print("🎓 전공: ");
        String lionmajor = sc.nextLine();
        System.out.print("📌 기수: ");
        int lion_generation = Integer.parseInt(sc.nextLine());
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String lionpart = sc.nextLine();
        System.out.print("🆔 학번: ");
        String studentId = sc.nextLine();
        System.out.println();

        // 입력받은 정보로 Lion 객체 생성
        AbstractMember lion = new Lion(lionname, lionmajor, lion_generation, lionpart, studentId);

        // 2. 운영진 정보 입력
        System.out.println("====== 👨‍💼 운영진 정보 입력 ======");
        System.out.print("👤 이름: ");
        String staffname = sc.nextLine();
        System.out.print("🎓 전공: ");
        String staffmajor = sc.nextLine();
        System.out.print("📌 기수: ");
        int staff_genrtation = Integer.parseInt(sc.nextLine());
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): ");
        String staffpart = sc.nextLine();
        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): ");
        String staffposition = sc.nextLine();
        System.out.println();

        // 입력받은 정보로 Staff 객체 생성
        AbstractMember staff = new Staff(staffname, staffmajor, staff_genrtation, staffpart, staffposition);

        // 3. 결과 출력 (객체 스스로 판단하고 출력하도록 지시)
        System.out.println("====== 📝 결과 출력 ======\n");
        lion.printInfo();
        staff.printInfo();

        sc.close();
    }
}