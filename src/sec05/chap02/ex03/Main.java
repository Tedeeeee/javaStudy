package src.sec05.chap02.ex03;

public class Main {
    public static void main(String[] args) {

        // 이런식으로 menu 판을 만들고 한 매장에 전부 등록이 가능하다
        ChickenMenu[] menus = {
                new ChickenMenu("후라이드", 10000),
                new ChickenMenu("양념치킨", 12000),
                new ChickenMenu("화덕구이", 15000, "bake")
        };

        // 그 메뉴를 가지고 객체를 생성한다.
        TaesikChicken store1 = new TaesikChicken(1, "판교", menus);

        ChickenMenu order1 = store1.orderMenu("양념치킨");
        ChickenMenu order2 = store1.orderMenu("화덕구이");

        // 원시 자료형은 서로의 값에 영향을 주지 않는다.
        int int1 = 1;
        int int2 = int1;
        int1 = 2;

        String str1 = "헬롱";
        String str2 = str1;
        str1 = "원드";


        // 배열 혹은 클래스 같은 객체는 복사가 이루어지는 것이기에 원본 객체를 변경하면 복사한 객체의 값도 변경된다.
        ChickenMenu menu1 = new ChickenMenu("후라이등", 10000);
        ChickenMenu menu2 = menu1;
        menu1.price = 20000;


        // static 메소드가 생긴 후 값을 변경
        int avgChickenPrice = 12000;
        ChickenMenu chickenMenu = new ChickenMenu("양념치킨", 12000);

        raisePrice(avgChickenPrice, chickenMenu, 1000);
    }

    // 가격을 올리는 메소드
    public static void raisePrice(int avg, ChickenMenu menu, int amount) {
        // 원시 자료형은 값에 영향을 주지 않는다
        // avg 값을 바꾼다고 avgChickenPrice의 값이 바뀌는 것이 아니다.
        avg += amount;

        // 참조 자료형의 값을 바꾸면 위에 메소드를 활용한 chickenMenu 의 필드값도 바뀐다.
        menu.price += amount;
    }
}
