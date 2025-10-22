import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 사용자 입력 변수 선언
        String userChoice;

        while (true) {
            System.out.println("[ BURGERKING \uD83D\uDC51 MENU ]\n");
            System.out.println("1. 통새우와퍼       | W 8.9  | 통새우, 스파이시 토마토 소스, 순쇠고기 패티가 들어간 통새우와퍼");
            System.out.println("2. 몬스터와퍼       | W 10.3 | 디아블로 소스, 순쇠고기 패티, 치킨 패티가 들어간 몬스터와퍼");
            System.out.println("3. 콰트로치즈와퍼    | W 8.7  | 4가지 치즈, 순쇠고기 패티가 들어간 치즈와퍼");
            System.out.println("4. 트러플머쉬룸와퍼  | W 9.8   | 트러플 향, 4가지 버섯이 들어간 트러플머쉬룸와퍼");
            System.out.println("0. 종료           | 종료");

            System.out.print("주문하실 메뉴 번호를 입력해주세요(0번은 종료): ");
            userChoice = sc.next();

            if ("0".equalsIgnoreCase(userChoice))
                break;

            switch (userChoice) {
                case "1":
                    System.out.println("1. 통새우와퍼       | W 8.9  | 통새우, 스파이시 토마토 소스, 순쇠고기 패티가 들어간 통새우와퍼\n");
                    break;
                case "2":
                    System.out.println("2. 몬스터와퍼       | W 10.3 | 디아블로 소스, 순쇠고기 패티, 치킨 패티가 들어간 몬스터와퍼\n");
                    break;
                case "3":
                    System.out.println("3. 콰트로치즈와퍼    | W 8.7  | 4가지 치즈, 순쇠고기 패티가 들어간 치즈와퍼\n");
                    break;
                case "4":
                    System.out.println("4. 트러플머쉬룸와퍼  | W 9.8   | 트러플 향, 4가지 버섯이 들어간 트러플머쉬룸와퍼\n");
                    break;
                default:
                    System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.\n");
                    break;
            }
        }


    }
}