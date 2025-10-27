import java.util.ArrayList;
import java.util.List;

// MenuItem 클래스를 관리하는 클래스입니다.
public class Menu {
    // 속
    // 카테고리 필드 선언 - 버거, 음료, 사이드류 등
    private String category;

    private List<MenuItem> menuItemList = new ArrayList<>();


    // 생
    public Menu() {}
    public Menu (String category, List<MenuItem> menuItemList) {
        this.category = category;
        this.menuItemList = menuItemList;
    }

    // 기
    public String getCategory() {
        return this.category;
    }

    public List<MenuItem> getMenuItemList() {
        return this.menuItemList;
    }

}

