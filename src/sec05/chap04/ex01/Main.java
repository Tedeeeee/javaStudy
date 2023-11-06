package src.sec05.chap04.ex01;

public class Main {
    public static void main(String[] args) {
        SmartPhone phone = new SmartPhone();

        String pb = phone.powerButton;
        String ss = phone.sdCardSlot;

        // 이것은 접근 제어자가 private( 같은 클래스만 사용 가능 )이기 때문에 다른 곳에서는 사용 불가능
        // String cu = phone.cpu;
    }
}
