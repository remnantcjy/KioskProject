import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스 - <MenuItem> List 필드, start()
public class Kiosk {
    // 속성
    //MenuItem을 관리하는 리스트가 필드로 존재합니다.
    // 각 메뉴들을 저장할 리스트 !!! ex. 햄버거류, 음료류, 사이드류 등 - 공통 변수명 느낌으로 작성
    List<MenuItem> menuItems = new ArrayList<>();

    // 생성자
    // List<MenuItem> menuItems 는 Kiosk 클래스 생성자를 통해 값을 할당합니다.
    // Kiosk 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨줍니다.
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    // 기능
    //main 함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리
    public void start() {
        Scanner sc = new Scanner(System.in);

        // 메뉴 출력 - 반복문을 활용해 List 안에 있는 MenuItem을 하나씩 출력
        System.out.println("[ BURGERKING \uD83D\uDC51 MENU ]");
        int i = 1;
        for (MenuItem menu : menuItems) {
            System.out.println(i + ". " + menu);
            i++;
        }
        System.out.println("0. 종료           |   종료");



        // 사용자 입력 변수 선언
        String userChoice;

        while (true) {

            // 유효성 검증 메서드 - 숫자 외의 값 입력시 예외처리 및 재입력
            try {
                System.out.print("\n주문하실 메뉴의 번호를 입력해주세요: ");
                // 입력된 숫자에 따른 처리
                userChoice = sc.next();

                // 리스트에 인덱스로 접근하기 위해 정수로 변환
                int index = Integer.parseInt(userChoice);

                if ("0".equalsIgnoreCase(userChoice)) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else if(menuItems.size() < index) {
                    // 메뉴아이템리스트의 사이즈보다 인덱스가 클 때 재입력 받기
                    System.out.println("잘못된 메뉴 번호입니다. 다시 입력해주세요.\n");
                } else {
                    // 해당 인덱스의 값 출력하기
                    System.out.println("\n선택한 메뉴: " + menuItems.get(index-1));
                    System.out.println("0. 종료                  |   종료");
                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗\uFE0F");
            }

        }
    }
}
