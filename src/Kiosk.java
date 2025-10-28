import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
public class Kiosk {
    // 속성
    private List<Menu> menuList;
    private Scanner sc = new Scanner(System.in);
    private Menu selectedMenu;

    // 생성자
    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }


    // 키오스크 실행 메서드
    public void start() {

        while (true) {
            // 1. 카테고리 처리
            Command command = handleCategory();

            // 1-a. command 가 "exit" 일 때
            if (command.getCommand().equalsIgnoreCase("exit")) {
                break;  // 프로그램 종료
            }

            // 2. 메뉴아이템 처리
            handleMenuItem();
        }
    }


    // 메뉴아이템 처리 - Menuitem
    private void handleMenuItem() {

        // 1. 선택한 메뉴의 메뉴아이템을 출력
        List<MenuItem> menuItemList = selectedMenu.getMenuItemList();

        // 1-a. 메뉴아이템 리스트 사이즈만큼 반복문
        for (int i = 0; i < menuItemList.size(); i++) {

            // 1-b. 메뉴아이템 리스트를 인덱스로 접근 -> 해당 메뉴아이템 출력
            System.out.println(i + 1 + ". " + menuItemList.get(i));
        }

        // 1-c. 뒤로가기 출력
        System.out.println("0. 뒤로가기");


        while (true) {
            try {

                // 2. 사용자로부터 메뉴아이템 입력
                int inputMenuItem = sc.nextInt();

                // 2-a. 0번 -> 뒤로가기 입력시
                if (inputMenuItem == 0) {
                    break;
                }

                // 3. 선택한 메뉴아이템 찾기
                MenuItem selectedMenuItem = menuItemList.get(inputMenuItem - 1);

                // 4. 선택한 메뉴아이템 출력
                System.out.println("선택한 메뉴아이템: " + selectedMenuItem);

                break;

            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                sc.nextLine();  // 버퍼 비우기
            }
        }
    }


    // 카테고리 처리 - Category
    private Command handleCategory() {

        // 1. 카테고리 출력
        System.out.println("[ MAIN MENU ]");

        // 1-a. 메뉴리스트 사이즈만큼 반복문
        for (int i=0; i<menuList.size(); i++) {
            // 1-b. 메뉴리스트를 인덱스로 접근 -> 해당 카테고리 메뉴 출력
            System.out.println(i+1 + ". " + menuList.get(i).getCategory());
        }

        // 1-c. 종료 출력
        System.out.println("0. 종료       |   종료");


        while (true) {
            try {

                // 2. 사용자로부터 카테고리(메뉴) 입력
                int inputCategory = sc.nextInt();

                // 2-a. 사용자 입력 값이 0일 때
                if (inputCategory == 0) {
                    System.out.println("프로그램을 종료합니다.");

                    return new Command("exit");
                } else {

                    // 3. 입력 값에 해당하는 카테고리 조회
                    Menu selectedMenu = menuList.get(inputCategory - 1);


                    // 4. 선택한 카테고리를 필드에 저장
                    this.selectedMenu = selectedMenu;
                }

                // Enum 적용 가능
                return new Command("MainItem");

            }  catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                sc.nextLine();  // 버퍼 비우기
            }
        }
    }
}
