package Week2;

import java.util.Scanner;

public class IndexControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = 0;


        while (true) {

            System.out.println("🦁 저장할 아기사자 수를 5 이상 입력해주세요.");
            number = sc.nextInt(); // 여기서 숫자가 아니면 catch로 이동
            if (number < 5) {
                System.out.println("❗️ [오류] 5 이상 입력해주세요.\n");
                continue;
            }
            break;
        }


        String[] names = new String[number];
        System.out.println("✏️ 아기사자 이름을 입력해주세요.");
        for (int i = 0; i < number; i++) {
            names[i] = sc.next();
        }
        System.out.println("\n📋 아기사자 명단을 최종적으로 출력합니다.");
        for (int i = 0; i < names.length ; i++) {
            System.out.println("🦁" + (i+1) + ". " + names[i]);}
        System.out.println("");
    }
}
