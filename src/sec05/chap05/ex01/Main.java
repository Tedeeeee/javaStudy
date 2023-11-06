package src.sec05.chap05.ex01;

public class Main {
    public static void main(String[] args) {
        TaesikChickenDT dtStore1 = new TaesikChickenDT(104, "철원");

        dtStore1.takeHallOrder();

        dtStore1.takeDTOrder();
        dtStore1.setDriveThruOpen(false);
        dtStore1.takeDTOrder();
    }
}
