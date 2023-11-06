package src.sec05.chap03.ex01;

public class Main {
    public static void main(String[] args) {
        // 클래스 필드와 메소드는 인스턴스를 굳이 생성하지 않고도 사용할 수 있다.
        String tsBrand = TaesikChicken.brand;
        String tsContact = TaesikChicken.contact();

        TaesikChicken.brand = "이렇게 바꿀수도 있나?";

        // 인스턴스 메소드는 객체 생성을 해준 후에 가능하다.
        TaesikChicken store1 = new TaesikChicken(3, "판교");
        String st1Intro = store1.intro();

        // 인스턴스에서는 클래스의 필드와 메소드 사용이 가능하다
        // 하지만 권장하지 않는다.
        String st1Brand = store1.brand;
    }
}
