import java.util.ArrayList;
import java.util.List;

// 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스 - <MenuItem> List 필드, start()
public class Kiosk {
    // 속성
    //MenuItem을 관리하는 리스트가 필드로 존재합니다.
    // 각 메뉴들을 저장할 리스트 !!! ex. 햄버거류, 음료류, 사이드류 등 - 공통 변수명 느낌으로 작성
    List<MenuItem> menuItems = new ArrayList<>();

    // 생성자
    // List<MenuItem> menuItems 는 Kiosk 클래스 생성자를 통해 값을 할당합니다.
    // Kiosk 객체를 생성하고 사용하는 main 함수에서 객체를 생성할 때 값을 넘겨줍니다.
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }


    // 기능
    //main 함수에서 관리하던 입력과 반복문 로직은 이제 start 함수를 만들어 관리
    public void start() {

    }
}
