import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // MenuItem 객체를 담을 수 있게 리스트를 생성
        List<MenuItem> burgerItems = new ArrayList<>();
        List<MenuItem> drinkItems = new ArrayList<>();
        List<MenuItem> dessertItems = new ArrayList<>();

        // MenuCreate 클래스 - createBurgerMenu() 함수 호출 시 메뉴아이템들이 들어있는 메뉴가 리턴
        // MenuItem 객체 생성 및 메뉴아이템s 리스트에 추가
        burgerItems.add(new MenuItem("Shrimp Whopper", 8.9, "통새우, 스파이시 토마토 소스, 순쇠고기 패티가 들어간 통새우와퍼"));
        burgerItems.add(new MenuItem("Monster Whopper", 10.3, "디아블로 소스, 순쇠고기 패티, 치킨 패티가 들어간 몬스터와퍼"));
        burgerItems.add(new MenuItem("QuattroCheese Whopper", 8.7, "4가지 치즈, 순쇠고기 패티가 들어간 치즈와퍼"));
        burgerItems.add(new MenuItem("TruffleMushroom Whopper", 9.8, "트러플 향, 4가지 버섯이 들어간 트러플머쉬룸와퍼"));

        drinkItems.add(new MenuItem("Coca Cola", 3.2, "코카콜라로 더 짜릿하게"));
        drinkItems.add(new MenuItem("Sprite", 3.2, "나를 깨우는 상쾌함"));
        drinkItems.add(new MenuItem("Ice Choco", 3.2, "달콤한 초코, 시원하게 즐기세요"));
        drinkItems.add(new MenuItem("Ice Americano", 2.4, "자연을 담은 버거킹 RA인증커피"));

        dessertItems.add(new MenuItem("French Fries", 3.6, "세계최고의 감자만 엄선해서 바삭하게, 프랜치프라이"));
        dessertItems.add(new MenuItem("Cheese Stick", 3.4, "진하고 고소한 자연 모짜렐라가 가득한 치즈스틱"));
        dessertItems.add(new MenuItem("Nugget King", 5.3, "바삭 촉촉 한입에 쏙, 부드러운 너겟킹"));
        dessertItems.add(new MenuItem("Onion Rings", 5.0, "통째로 썰어 더 두툼하고 더 바삭해진"));

        //  List<MenuItem> menuItems 는 Kiosk 클래스 생성자를 통해 값을 할당합니다.
        //  Kiosk 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨줍니다.

        // Menu 객체 생성을 통해 카테고리명, List<MenuItem> 전달
        Menu burgers = new Menu("Burgers", burgerItems);
        Menu drinks = new Menu("Drinks", drinkItems);
        Menu desserts = new Menu("Desserts", dessertItems);

        // 총 카테고리 리스트
        List<Menu> totalCategory = new ArrayList<>();
        totalCategory.add(burgers);
        totalCategory.add(drinks);
        totalCategory.add(desserts);

        Kiosk kiosk = new Kiosk(totalCategory);

        // 키오스크 주문 기능
        kiosk.start();
    }
}