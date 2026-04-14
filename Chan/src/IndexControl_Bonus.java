import java.util.Scanner;
import java.util.InputMismatchException;

public class IndexControl_Bonus {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            int number = 0;

            while (true) {
                try {
                    System.out.println("🦁 저장할 아기사자 수를 5 이상 입력해주세요.");
                    number = sc.nextInt(); // 여기서 숫자가 아니면 catch로 이동

                    if (number < 5) {
                        System.out.println("❗️ [오류] 5 이상 입력해주세요.\n");
                        continue;
                    }
                    break;

                } catch (InputMismatchException error) {
                    System.out.println("❌ [에러] 숫자만 입력할 수 있습니다.\n");
                    sc.nextLine();
                }
            }

            String[] names = new String[number];
            sc.nextLine();
            System.out.println("✏️ 아기사자 이름을 입력해주세요.");
            for (int i = 0; i < number; i++) {
                while(true) {
                    String name = sc.nextLine();
                    if (name.isEmpty()) {
                        System.out.println("⚠️ 이름이 비어있습니다. 다시 입력해주세요.");
                        continue;
                    }
                    boolean check = false;
                    for (int j = 0; j < i ; j++){
                        if(name.equals(names[j])){
                            System.out.println("️⚠️이미 등록된 이름입니다. 다시 입력해주세요.");
                            check = true;
                            break;
                        }
                    }
                    if (check == true){
                        continue;
                    }
                    names[i] = name;
                    break;
                }
            }

            System.out.println("\n📋 아기사자 명단을 최종적으로 출력합니다.");
            for (int i = 0; i < names.length; i++) {
                System.out.println("🦁" + (i + 1) + ". " + names[i]);
            }

            System.out.println("================");

            while (true){
                System.out.println("🚨 프로그램을 종료하려면 'exit'를 입력하세요.");
                System.out.println("🔁 계속 아기사자를 등록하려면 'restart'를 입력하세요. \n");
                String command = sc.nextLine();

                if (command.equalsIgnoreCase("restart")) {
                    break;
                } else if (command.equalsIgnoreCase("exit")) {
                    System.out.println("👋아기 사자 명단 프로그램을 종료합니다.");
                    return;
                } else {
                    System.out.println("❌ 잘못된 명령어입니다.\n");
                }
            }
        }
    }
}
