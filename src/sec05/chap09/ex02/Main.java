package src.sec05.chap09.ex02;

public class Main {
    public static void main(String[] args) {
        // static 메소드인 announcement는 이렇게 바로 불러올수 있다.
        // 그것이 인터페이스 이더라도 말이다.
        FoodSafety.announcement();

        TaesikChicken store1 = new TaesikChicken();

        store1.regularInspection();
        store1.cleanKitchen();
        store1.employeeEducation();
    }
}
