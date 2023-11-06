package src.sec06.chap04.Ex01;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();

        button.setButtonMode(ButtonMode.DARK);
        button.setButtonSpace(ButtonSpace.SINGLE);

        // 이렇게 오용을 방지 할 수 있는 ENUM이 있다.
        // button.setButtonMode(ButtonSpace.DOUBLE);
    }
}
