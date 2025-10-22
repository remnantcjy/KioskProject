import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // MenuItem 객체를 담을 수 있게 객체를 생성하고,
        // 현재는 햄버거류만 담을 수 있게 변수명을 burgerItems로 선언했다.
        List<MenuItem> burgerItems = new ArrayList<>();

        // MenuItem 객체 생성 및 메뉴아이템s 리스트에 추가
        burgerItems.add(new MenuItem("통새우와퍼", 8.9, "통새우, 스파이시 토마토 소스, 순쇠고기 패티가 들어간 통새우와퍼"));
        burgerItems.add(new MenuItem("몬스터와퍼", 10.3, "디아블로 소스, 순쇠고기 패티, 치킨 패티가 들어간 몬스터와퍼"));
        burgerItems.add(new MenuItem("콰트로치즈와퍼", 8.7, "4가지 치즈, 순쇠고기 패티가 들어간 치즈와퍼"));
        burgerItems.add(new MenuItem("트러플머쉬룸와퍼", 9.8, "트러플 향, 4가지 버섯이 들어간 트러플머쉬룸와퍼"));

        //  List<MenuItem> menuItems 는 Kiosk 클래스 생성자를 통해 값을 할당합니다.
        //  Kiosk 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨줍니다.

        // 키오스크 필드 선언 및 객체 생성 - 버거류 리스트 값을 할당!
        Kiosk kiosk = new Kiosk(burgerItems);

        // 키오스크 주문 기능
        kiosk.start();
    }
}