package src.sec05.chap06.ex02;

public class Main {
    public static void main(String[] args) {
/*
        TaesikChickenDT dtStore1 = new TaesikChickenDT(104, "철원");

        dtStore1.takeHallOrder();

        dtStore1.takeDTOrder();
        dtStore1.setDriveThruOpen(false);
        dtStore1.takeDTOrder();
 */
        TaesikChicken tsStores[] = {
                new TaesikChicken(3, "판교"),
                new TaesikChicken(16, "강남"),
                new TaesikChickenDT(233, "아현")
        };

        for (TaesikChicken store : tsStores) {
            if (store instanceof TaesikChickenDT) {
                // 부모(store)가 자식의 기능을 사용하려면 타입 변환을 해주어야 한다.
                ((TaesikChickenDT) store).takeDTOrder();
            } else {
                store.takeHallOrder();
            }
        }
    }
}
