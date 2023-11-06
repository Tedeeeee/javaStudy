package src.sec05.chap06.ex02;

public class TaesikChickenDT extends TaesikChicken {

    /**
     * 내가 그냥 치킨집 뿐만 아니라 드라이브스루가 가능한 치킨집 까지 만들고 싶다.
     */

    private boolean driveThruOpen = true;
    public TaesikChickenDT(int no, String name) {
        super(no, name);
    }

    public void setDriveThruOpen(boolean driveThruOpen) {
        this.driveThruOpen = driveThruOpen;
    }

    public void takeDTOrder() {
//        System.out.printf(
//                "%d호 %s점 드라이브스루 주문 %s%n",
//                no, name,
//                (driveThruOpen ? "받음" : "불가능")
//        );
    }
}
