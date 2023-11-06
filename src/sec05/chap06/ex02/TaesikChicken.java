package src.sec05.chap06.ex02;

public class TaesikChicken {
    protected int no;
    protected String name;

    public TaesikChicken(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void takeHallOrder() {
        System.out.printf("%d 호 %s점 홀 주문 받음%n", no, name);
    }
}
