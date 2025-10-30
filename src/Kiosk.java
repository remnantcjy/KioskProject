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
    private MenuItem selectedMenuItem;
    private Cart cart;

    // 생성자
    public Kiosk(List<Menu> menuList, Cart cart) {
        this.menuList = menuList;
        this.cart = cart;
    }

    // 선택한 메뉴아이템 -> 메뉴아이템 리스트 생성

    // 카트 생성 및 선택한 메뉴아이템 리스트 값 할당
    // 카트는 흐름 제어 아님 - Scanner 와 다름

    // 키오스크 - 흐름 제어

    // 키오스크 실행 메서드
    public void start() {
        while (true) {

                // 1. 카테고리 처리 - command 가 "Category"
                Command command = handleCategory();

                // 1-a. command 가 "exit" 일 때
                if (command.getCommand().equalsIgnoreCase("exit")) {
                    break;  // 프로그램 종료
                } else if (command.getCommand().equalsIgnoreCase("MainItem")) {
                    // 2. 메뉴아이템 처리
                    command = handleMenuItem();
                }


                if (command.getCommand().equalsIgnoreCase("Category")) {
                    continue;
                } else if (command.getCommand().equalsIgnoreCase("Cart")) {
                    // 3. 장바구니 처리
                    command = handleCart();
                } else if (command.getCommand().equalsIgnoreCase("Order")) {
                    handleOrder();
                }
        }
    }

    private double handleDiscount(double totalPrice) {
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println("1. 국가유공자 : 10%");
        System.out.println("2. 군인     :  5%");
        System.out.println("3. 학생     :  3%");
        System.out.println("4. 일반     :  0%");

        while (true) {
            try {
                int inputDiscount = sc.nextInt();

                if (inputDiscount == 1) {
                    totalPrice *= 0.9;
                } else if (inputDiscount == 2) {
                    totalPrice *= 0.95;
                } else if (inputDiscount == 3) {
                    totalPrice *= 0.97;
                } else if (inputDiscount == 4) {
                    totalPrice *= 1;
                } else {
                    System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                sc.nextLine();  // 버퍼 비우기
                continue;
            }
            return totalPrice;
        }
    }

    private Command handleOrder() {
        // 주문당 총 금액
        double totalPrice = cart.printCart();

        // 7. 사용자로부터 주문 or 메뉴판 입력
        while (true) {
            try {
                System.out.println("1. 주문      2. 메뉴판");

                int  inputOrder = sc.nextInt();
                System.out.println();


                if (inputOrder == 1) {

                    // 장바구니는 장바구니 기능만
                    // 할인은 할인 객체로 따로
                    totalPrice = handleDiscount(totalPrice);

                    System.out.println();
                    System.out.println("주문이 완료되었습니다. 금액은 W " + String.format("%.1f", totalPrice) + " 입니다.\n");

                    // 카트 비우기
                    cart.clear();
                    return new Command("Category");
                } else if (inputOrder == 2) {
                    return new Command("Category");
                } else {
                    System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                sc.nextLine();  // 버퍼 비우기
            }
        }

    }

    private Command handleCart() {
        // 1. 메뉴아이템 출력 + 장바구니 추가 메시지 출력
        System.out.println("\"" + selectedMenuItem + "\"\n");
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");

        while (true) {
            try {
                // 2. 사용자로부터 장바구니 번호 입력
                int inputCart = sc.nextInt();

                // 3-a. 추가 o -> selectedMenuItem.getName() + 추가됐다는 메시지 출력
                if (inputCart == 1) {
                    // 선택한 메뉴아이템 리스트에 선택한 메뉴아이템 추가
                    cart.addCart(selectedMenuItem);

                    // 선택된 메뉴아이템 메시지 출력
                    System.out.println("\n" + selectedMenuItem.getName() + " 가 장바구니에 추가되었습니다.\n");

                    break;
//                    // 취소
                } else if (inputCart == 2){
                    System.out.println();
                    break;

                } else {
                    System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                sc.nextLine();  // 버퍼 비우기
            }
        }
        return new Command("Category");
    }


    // 메뉴아이템 처리 - Menuitem
    private Command handleMenuItem() {

        // 0. 카테고리 메뉴 출력
        System.out.println("[ " + selectedMenu.getCategory() + " MENU ]");

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
                System.out.println();

                // 2-a. 0번 -> 뒤로가기 입력시
                if (inputMenuItem == 0) {
                    return new Command("Category");
//                    break;
                }

                // 3. 선택한 메뉴아이템 찾기
                MenuItem selectedMenuItem = menuItemList.get(inputMenuItem - 1);

                // 4. 선택한 메뉴아이템 출력
                System.out.println("선택한 메뉴: " + selectedMenuItem + "\n");

                // 5. 선택한 메뉴아이템을 필드에 저장
                this.selectedMenuItem = selectedMenuItem;

                break;

            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                sc.nextLine();  // 버퍼 비우기
            }
        }

        return new Command("Cart");
    }


    // 카테고리 처리 - Category
    private Command handleCategory() {

        int cartSize = cart.getCart().size();

        if (cartSize > 0) {
            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.\n");
        }

        // 1. 카테고리 출력
        System.out.println("[ MAIN MENU ]");

        // 1-a. 메뉴리스트 사이즈만큼 반복문
        for (int i = 0; i < menuList.size(); i++) {
            // 1-b. 메뉴리스트를 인덱스로 접근 -> 해당 카테고리 메뉴 출력
            System.out.println(i + 1 + ". " + menuList.get(i).getCategory());
        }

        // 1-c. 종료 출력
        System.out.println("0. 종료       |   종료");


        if (cartSize > 0) {
            System.out.println();
            System.out.println("[ ORDER MENU ]");
            System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
        }

        while (true) {
            try {

                // 2. 사용자로부터 카테고리(메뉴) 입력
                int inputCategory = sc.nextInt();

                System.out.println();

                // 2-a. 사용자 입력 값이 0일 때
                if (inputCategory == 0) {
                    System.out.println("프로그램을 종료합니다.");

                    return new Command("exit");

                    // 프로그램 종료 아니고, 메뉴아이템 선택시
                } else if (inputCategory == 4) {
                    return new Command("Order");
                } else if (inputCategory == 5) {
                    break;
                } else {

                    // 3. 입력 값에 해당하는 카테고리 조회
                    Menu selectedMenu = menuList.get(inputCategory - 1);

                    // 4. 선택한 카테고리를 필드에 저장
                    this.selectedMenu = selectedMenu;

                    // Enum 적용 가능
                    return new Command("MainItem");
                }


            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("잘못된 입력 ❌ 메뉴 번호를 입력해주세요 ❗");
                sc.nextLine();  // 버퍼 비우기
            }
        }
        return new Command("Category");
    }
}



