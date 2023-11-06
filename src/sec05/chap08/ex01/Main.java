package src.sec05.chap08.ex01;

public class Main {
    public static void main(String[] args) {

        // 추상 클래스인 Group 에는 직접적인 인스턴스 생성이 불가능 하다.
        // TaesikGroup taesikGroup = new TaesikGroup(1, "서울");

        TaesikChicken tsCkStore1 = new TaesikChicken("판교");
        TaesikChicken tsCkStore2 = new TaesikChicken("강남");

        TaesikCafe tsCfStore1 = new TaesikCafe("울릉", true);
        TaesikCafe tsCfStore2 = new TaesikCafe("독도", false);

        TaesikGroup[] tsGroup = {
                tsCkStore1, tsCkStore2, tsCfStore1, tsCfStore2
        };

        for (TaesikGroup tsStore : tsGroup) {
            tsStore.takeOrder();
        }

        System.out.println("\n- - - - - - -\n");

        System.out.println(TaesikChicken.getCreed());
        System.out.println(TaesikCafe.getCreed());
    }
}
