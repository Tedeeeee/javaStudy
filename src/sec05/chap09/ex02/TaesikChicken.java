package src.sec05.chap09.ex02;

public class TaesikChicken implements FoodSafety {

    /**
     *  default 메소드는 구현을 해도되고 안해도된다
     *  static 메소드는 따로 구현하지 않아도 된다.
     */

    @Override
    public void cleanKitchen() {
        System.out.println("매일 주방을 청소해야해");
    }

    @Override
    public void employeeEducation() {
        System.out.println("직원 월급 밀리지마");
    }
}
