import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
public class Kiosk {
    // 속성
    List<Menu> totalCategory;

    // List<Menu>로 변경 <Menu> - 메뉴랑 메뉴 아이템 관계처럼
    // 생성자
    public Kiosk(List<Menu> totalCategory) {
        this.totalCategory = totalCategory;
    }

    // 기능
    public void printMenuList() {
        System.out.println("[ MAIN MENU ]");
        int i = 1;
        for (Menu menu : totalCategory) {
            System.out.println(i + ". " + menu.getMenu());
            i++;
        }
        System.out.println("0. 종료       |   종료");
    }

    // 메뉴 객체 받음 - 메뉴 객체 안에 메뉴아이템 리스트가 있음.
    public void printMenuItemList(Menu selectedCategory) {
        List<MenuItem> selectedMenuItem = selectedCategory.getMenuItem();

        System.out.println();

        for (int i=0; i<selectedMenuItem.size(); i++) {
            System.out.println(i+1 + ". " + selectedMenuItem.get(i));
        }
    }


    // 키오스크 실행 메서드
    public void start() {
        Scanner sc = new Scanner(System.in);

        // 카테고리 번호를 입력할 변수 선언
        int categoryChoice;

        while (true) {

            // 메뉴 목록 출력
            printMenuList();
            categoryChoice = sc.nextInt();

            if (0 == categoryChoice) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else {
                Menu selectedCategory = totalCategory.get(categoryChoice-1);
                printMenuItemList(selectedCategory);

                List<MenuItem> selectedMenuItem = selectedCategory.getMenuItem();
                System.out.println("0. 뒤로가기");

                while (true) {
                    try {
                        // 메뉴아이템 or 뒤로가기 입력 변수
                        int itemChoice = sc.nextInt();
                        if (itemChoice == 0) {
                            System.out.println();
                        } else {
                            // 해당 인덱스의 값 출력하기
                            System.out.println("선택한 메뉴: " + selectedMenuItem.get(itemChoice-1) + "\n");
                        }
                        break;
                    } catch (IndexOutOfBoundsException | InputMismatchException e) {
                        System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                        sc.nextLine();
                    }
                }
            }
        }
    }
}
