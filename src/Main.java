import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // List 선언 및 생성
        List<MenuItem> menuItems = new ArrayList<>();

        // MenuItem 객체 생성 및 메뉴아이템s 리스트에 추가
        menuItems.add(new MenuItem("통새우와퍼", 8.9, "통새우, 스파이시 토마토 소스, 순쇠고기 패티가 들어간 통새우와퍼"));
        menuItems.add(new MenuItem("몬스터와퍼", 10.3, "디아블로 소스, 순쇠고기 패티, 치킨 패티가 들어간 몬스터와퍼"));
        menuItems.add(new MenuItem("콰트로치즈와퍼", 8.7, "4가지 치즈, 순쇠고기 패티가 들어간 치즈와퍼"));
        menuItems.add(new MenuItem("트러플머쉬룸와퍼", 9.8, "트러플 향, 4가지 버섯이 들어간 트러플머쉬룸와퍼"));

        Scanner sc = new Scanner(System.in);

        // 메뉴 출력 - 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        System.out.println("[ BURGERKING \uD83D\uDC51 MENU ]");
        for (MenuItem menu : menuItems) {
            System.out.println(menu);
        }

        // 사용자 입력 변수 선언
        String userChoice;

        while (true) {
            System.out.print("\n주문하실 메뉴의 번호를 입력해주세요(0번은 종료): ");
            // 입력된 숫자에 따른 처리
            userChoice = sc.next();

            // 리스트에 인덱스로 접근하기 위해 정수로 변환
            int index = Integer.parseInt(userChoice);

            if ("0".equalsIgnoreCase(userChoice)) {
                break;
            } else if(menuItems.size() < index) {
                // 메뉴아이템리스트의 사이즈보다 인덱스가 클 때 재입력 받기
                System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.\n");
            } else {
                // 해당 인덱스의 값 출력하기
                System.out.println("\n선택한 메뉴: " + menuItems.get(index-1));
            }
        }
    }
}