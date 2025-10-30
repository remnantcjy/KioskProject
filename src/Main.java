import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. 각 카테고리 리스트 생성
        List<MenuItem> burgerItemList = new ArrayList<>();
        List<MenuItem> drinkItemList = new ArrayList<>();
        List<MenuItem> dessertItemList = new ArrayList<>();

        // 2. 메뉴아이템리스트에 각 아이템 생성 및 추가
        createBurgerItem(burgerItemList);
        createDrinkItem(drinkItemList);
        createDessertItem(dessertItemList);

        // 3. 각 메뉴 생성 (카테고리 이름, 각 메뉴아이템리스트)
        Menu burgerMenu = new Menu("Burgers", burgerItemList);
        Menu drinkMenu = new Menu("Drinks", drinkItemList);
        Menu dessertMenu = new Menu("Desserts", dessertItemList);

        // 4. 메뉴 리스트 생성 및 추가
        List<Menu> menuList = new ArrayList<>();
        menuList.add(burgerMenu);
        menuList.add(drinkMenu);
        menuList.add(dessertMenu);

        // 의존성 x - 키오스크 구성하는 객체 한 눈에 보기 쉽다. (=근거) 한 눈에 구성하는 객체가 main에 있습니다. (정의) - 나의 규칙 ( + 논리적 근거)
        Cart cart = new Cart();

        // 5. 키오스크 생성 및 메뉴리스트 값 할당
        Kiosk kiosk = new Kiosk(menuList, cart);

        // 6. 키오스크 주문 메서드 호출
        kiosk.start();
    }

    // 버거 아이템 생성 및 추가
    private static void createBurgerItem(List<MenuItem> burgerItems) {
        burgerItems.add(new MenuItem("Shrimp Whopper", 8.9, "통새우, 스파이시 토마토 소스, 순쇠고기 패티가 들어간 통새우와퍼"));
        burgerItems.add(new MenuItem("Monster Whopper", 10.3, "디아블로 소스, 순쇠고기 패티, 치킨 패티가 들어간 몬스터와퍼"));
        burgerItems.add(new MenuItem("QuattroCheese Whopper", 8.7, "4가지 치즈, 순쇠고기 패티가 들어간 치즈와퍼"));
        burgerItems.add(new MenuItem("TruffleMushroom Whopper", 9.8, "트러플 향, 4가지 버섯이 들어간 트러플머쉬룸와퍼"));
    }

    // 음료 아이템 생성 및 추가
    private static void createDrinkItem(List<MenuItem> drinkItems) {
        drinkItems.add(new MenuItem("Coca Cola", 3.2, "코카콜라로 더 짜릿하게"));
        drinkItems.add(new MenuItem("Sprite", 3.2, "나를 깨우는 상쾌함"));
        drinkItems.add(new MenuItem("Ice Choco", 3.2, "달콤한 초코, 시원하게 즐기세요"));
        drinkItems.add(new MenuItem("Ice Americano", 2.4, "자연을 담은 버거킹 RA인증커피"));
    }

    // 디저트 아이템 생성 및 추가
    private static void createDessertItem(List<MenuItem> dessertItems) {
        dessertItems.add(new MenuItem("French Fries", 3.6, "세계최고의 감자만 엄선해서 바삭하게, 프랜치프라이"));
        dessertItems.add(new MenuItem("Cheese Stick", 3.4, "진하고 고소한 자연 모짜렐라가 가득한 치즈스틱"));
        dessertItems.add(new MenuItem("Nugget King", 5.3, "바삭 촉촉 한입에 쏙, 부드러운 너겟킹"));
        dessertItems.add(new MenuItem("Onion Rings", 5.0, "통째로 썰어 더 두툼하고 더 바삭해진"));
    }
}