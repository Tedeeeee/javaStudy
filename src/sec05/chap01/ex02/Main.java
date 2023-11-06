package src.sec05.chap01.ex02;

public class Main {
    public static void main(String[] args) {

        // store1 이라는 매장이 생겼다. = 인스턴스를 생성했다.
        TaesikChicken store1 = new TaesikChicken();

        // 이런식으로 인스턴스로 만들어진 객체에 필드를 접근한다.
        store1.no = 1;
        store1.name = "판교";

        // store2 라는 두번째 체인점이 생겼다.
        TaesikChicken store2 = new TaesikChicken();
        store2.no = 2;
        store2.name = "강남";

        // 인스턴스의 필드에 접근하려고 한다면 이렇게 작성해준다면 그 값을 저장할 수 있다
        int store1Num = store1.no;
        String store2Name = store2.name;

        // 인스턴스의 메소드를 호출 할 수 있다.
        String store1Intro = store1.intro();
    }
}
