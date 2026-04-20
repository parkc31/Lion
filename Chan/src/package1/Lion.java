package package1;

public class Lion {
    // 멤버 변수 (서로 다른 3개의 접근 제어자로 구성)
    public String name;
    String major;
    private int generation;

    public void PrintInfo(){
        System.out.println("🦁 아기사자 정보를 출력합니다.");
        System.out.printf("🦁 이름: %s | 🎓 전공: %s | 📌 기수: %d", name, major, generation);
    }
    // 세 필드를 모두 초기화하는 생성자
    public Lion(String name, String major, int generation){

        // 입력값 유효성 검증
        if (name.isEmpty()){
            System.out.println("❌ 이름은 비어 있을 수 없습니다.");
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
            return;
        } else if (major.isEmpty()) {
            System.out.println("❌ 전공은 비어 있을 수 없습니다.");
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
            return;
        } else if (generation < 1){
            System.out.println("❌ 기수는 1 미만일 수 없습니다.");
            System.out.println("❌ 잘못된 아기사자 정보입니다.");
            return;
        }


        this.name = name;
        this.major = major;
        this.generation = generation;
    }



}
