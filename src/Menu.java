import java.util.ArrayList;
import java.util.List;

// MenuItem 클래스를 관리하는 클래스입니다.
public class Menu {
    // 속
    // 카테고리 필드 선언 - 버거, 음료, 사이드류 등
    private String category;

    //MenuItem을 관리하는 리스트가 필드로 존재합니다.
    // 각 메뉴들을 저장할 리스트 !!! ex. 햄버거류, 음료류, 사이드류 등 - 공통 변수명 느낌으로 작성
    List<MenuItem> menuItem = new ArrayList<>();


    // 생
    public Menu() {}
    public Menu (String category, List<MenuItem> menuItem) {
        this.category = category;
        this.menuItem = menuItem;
    }


    // 기
    // getter 생성
    // 메뉴 카테고리 이름을 반환하는 메서드
    public String getMenu() {
        return this.category;
    }

    public List<MenuItem> getMenuItem() {
        return this.menuItem;
    }
}

