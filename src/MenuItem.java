import java.util.ArrayList;
import java.util.List;

// 개별 음식 항목을 관리하는 클래스 - ex. 햄버거, 음료, 사이드 등
public class MenuItem {
    // 속 - private
    // 이름, 가격, 설명
    private String name;
    private double price;
    private String description;

    // 생성자의 특징
    // 1. 클래스명과 동일하다.
    // 2. 반환되는 데이터타입이 없다.
    // 3. 여러 개가 존재할 수 있다.

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // 기
    @Override
    public String toString() {
        return String.format("%-11s |   W %-5.1f |   %s", name, price, description);
    }
}
