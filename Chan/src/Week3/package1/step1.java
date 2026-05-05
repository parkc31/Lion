package Week3.package1;

import java.util.Scanner;

public class step1 {
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
        System.out.println("📌 입력값 검증을 시작합니다.");
        if (name.isEmpty()){
            System.out.println("❌ 이름은 비어 있을 수 없습니다.");
            return;
        } else if (major.isEmpty()) {
            System.out.println("❌ 전공은 비어 있을 수 없습니다.");
            return;
        } else if (generation < 1){
            System.out.println("❌ 기수는 1 미만일 수 없습니다.");
            return;
        }

        Lion lion = new Lion(name,major,generation);
    }
}
