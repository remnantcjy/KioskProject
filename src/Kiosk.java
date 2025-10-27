import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
public class Kiosk {
    // 속성
    private List<Menu> menuList;

    // 생성자
    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }


    // 키오스크 실행 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                // 1. 카테고리 처리
                handleCategory();

                // 2. 메뉴아이템 처리
                if (handleMenuItem(sc)) {
                    break;
                }
                // 예외 발생시 오류 메시지 출력 및 재입력 요청
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗\n");
                sc.nextLine();  // 버퍼 비우기
            }
        }
    }

    // 메뉴아이템 처리
    private boolean handleMenuItem(Scanner sc) {
        int inputCategory;  // 카테고리(메뉴) 변수

        // 1. 사용자로부터 카테고리(메뉴) 입력
        inputCategory = sc.nextInt();

        // 1-a. 0번 입력시 프로그램 종료 메시지 출력
        if (0 == inputCategory) {
            System.out.println("프로그램을 종료합니다.");
            return true;
        } else {
            // 2. 사용자로 입력 -> 카테고리 인덱스로 활용 -> 해당 카테고리의 메뉴아이템리스트 반환
            List<MenuItem> menuItemList = menuList.get(inputCategory - 1).getMenuItemList();

            // 2-a. 메뉴아이템 리스트를 순회하면서
            for (MenuItem menuItem : menuItemList) {
                // 2-b. 각 메뉴아이템을 출력
                System.out.println(menuItem);
            }

            // 4-a. 뒤로가기(카테고리) 출력
            System.out.println("0. 뒤로가기");

            while (true) {
                try {
                    // 4. 사용자로부터 메뉴아이템 입력
                    int inputMenuItem = sc.nextInt();

                    // 4-b. 0 입력시 카테고리로 돌아가기
                    if (inputMenuItem == 0) {
                        System.out.println();
                    } else {
                        // 5. 사용자 입력 -> 인덱스로 활용 -> 해당 메뉴아이템 출력
                        System.out.println("선택한 메뉴: " + menuItemList.get(inputMenuItem - 1) + "\n");
                    }
                    break;
                    // 6. 예외 발생시 오류 메시지 출력 및 재입력 요청
                } catch (IndexOutOfBoundsException | InputMismatchException e) {
                    System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                    sc.nextLine();  // 버퍼 비우기
                }
            }
        }
        return false;
    }

    // 카테고리 처리 메서드
    private void handleCategory() {
        // 카테고리 선택 변수
        int inputCategory;

        // 1. 카테고리 출력
        System.out.println("[ MAIN MENU ]");
        // 1-a. 메뉴리스트 사이즈만큼 반복문
        for (int i=0; i<menuList.size(); i++) {
            // 1-b. 메뉴리스트를 인덱스로 접근 -> 해당 카테고리 메뉴 출력
            System.out.println(i+1 + ". " + menuList.get(i).getCategory());
        }
        // 1-c. 종료 출력
        System.out.println("0. 종료       |   종료");
    }
}
