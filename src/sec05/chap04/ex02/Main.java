package src.sec05.chap04.ex02;

import src.sec05.chap04.ex01.SmartPhone;

public class Main {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();

        String ss = phone.sdCardSlot;

        // 이것은 default(같은 패키지까지만 가능)이기 때문에 다른 패키지인 곳은 사용이 불가능 하다
        // String pb = phone.powerButton;

        Button button1 = new Button('1', 199);

        // 현재 mode 가 private 이기에 여기서 직접적인 변동은 불가능 하다
        // Button.mode = "OCEAN";

        // 이렇게 변경해주어야 한다.
        Button.switchMode();

        // 이것또한 private 이기에 불가능
        // button1.space = 3;

        // set 을 사용해서 클래스의 필드를 조정한다.
        button1.setSpace(3);

        // 이것 또한 불가능
        // char button1Print = button1.print;

        String button1Info = button1.getButtonInfo();
    }
}
