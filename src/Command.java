
// 함수 흐름 제어를 위한 Command 객체
public class Command {
    // 속
    private String command;

    // 생
    public Command(String command) {
        this.command = command;
    }

    // 기
    public String getCommand() {
        return command;
    }
}
