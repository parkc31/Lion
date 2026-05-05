package Week3.package2;

import Week3.package1.Lion;

import java.util.Scanner;

public class step3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사용자로부터 이름, 전공, 기수 입력받음
        System.out.println("🦁 아기 사자 이름을 입력해주세요.");
        String name = sc.nextLine();
        System.out.println("🎓 아기 사자 전공을 입력해주세요.");
        String major = sc.nextLine();
        System.out.println("📌 아기 사자 기수를 입력해주세요.");
        int generation = sc.nextInt();

        sc.nextLine();

        // 입력값 유효성 검증
        System.out.println("⏩ 객체 생성이 완료되었습니다. 아기사자 객체의 상태를 확인합니다.");
        Lion lion = new Lion(name,major,generation);

        if (lion.name != null) {
            lion.PrintInfo();

            System.out.println("\n");

            // name 필드 값 변경
//            System.out.println("📌 Step 3-1. public 필드 접근을 시도합니다.");
//            System.out.println("👉 name 필드 값을 변경합니다.");
//            lion.name = "홍길동";
//            if (lion.name == "홍길동") {
//                System.out.println("✅ public 필드 접근 성공");
//                lion.PrintInfo();
//            }

            // major 필드 값 변경
//            System.out.println("📌 Step 3-1. default 필드 접근을 시도합니다.");
//            System.out.println("👉 major 필드 값을 변경합니다.");
//            lion.major = "바둑학과";

            // generaton 필드 값 변경
//            System.out.println("📌 Step 3-1. default 필드 접근을 시도합니다.");
//            System.out.println("👉 generation 필드 값을 변경합니다.");
//            lion.generation = "70000";
        }
    }
}
