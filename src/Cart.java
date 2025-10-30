import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Cart {
    // 속 - 인터페이스가 지원해줌 (유연한 사용) 컬렉션은 인터페이스에 의존
    private Map<MenuItem, Integer> cart = new HashMap<MenuItem, Integer>();    // 메뉴아이템, 수량 (가격은 메뉴아이템.getPrice())

    // 생

    // 기
    public Map<MenuItem, Integer> getCart() {
        return this.cart;
    }

    // map 에 아무것도 없을 때, how to put
    // 있는 경우
    public void addCart(MenuItem selectedMenuItem) {
        cart.put(selectedMenuItem, cart.getOrDefault(selectedMenuItem, 0) +1);

    }

    // 메뉴아이템명, 수량, 가격정보 필요
    public double printCart() {

        System.out.println("아래와 같이 주문 하시겠습니까?\n");
        System.out.println("[ Orders ]");


        double all = 0;

        for (Map.Entry<MenuItem, Integer> entry : cart.entrySet()) {
            double totalPrice = 1;

            MenuItem menuItem = entry.getKey();
            Integer value = entry.getValue();

            System.out.println("수량: " + value + "개 - " + menuItem);

            double price = menuItem.getPrice();

            totalPrice = value * price;
            all += totalPrice;

        }
        System.out.println();
        System.out.println("[ Total ]");
        System.out.println("W " + String.format("%.1f", all));
        System.out.println();

        return all;
    }

    public void clear() {
        cart.clear();
    }
}
