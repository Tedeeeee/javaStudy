package src.sec06.chap02.ex01;

import src.sec05.chap08.ex01.*;

public class Main {
    public static void main(String[] args) {
        TaesikGroup store1 = new TaesikChicken("울산");
        TaesikGroup store2 = new TaesikCafe("마산", true);

        // 치킨과 카페가 아닌 이례적으로 과메기 매장이 생겨버림
        // 근데 우린 과메기 매장을 만드는 클래스가 없기 때문에 과메기를 주문하는 로직이 필요해짐
        // 근데 우리는 과메기 매장을 계속 할 생각이 없기 때문에 그냥 한번만 주문하면 됨
        // 그래서 익명 클래스를 사용해서 한번만 만들어준다.
        TaesikGroup store3 = new TaesikGroup(1, "포항") {
            @Override
            public void takeOrder() {
                System.out.printf(
                        "유일한 태식과메기 %s 과메기를 주문해주세요.%n",
                        super.intro()
                );
            }

            // 이 메소드는 외부에서 사용할 수 없다. Override 된 메소드가 아니기에 자기자신이 사용하는 것은 가능하지만 외부의 기능이 사용할 수 는 없다.
            public void dryFish() {
                System.out.println("과메기 말리기");
            }
        };

        var store3Intro = store3.intro();
        store3.takeOrder();

        System.out.println("\n- - - - - - - -\n");

        for (var store : new TaesikGroup[]{store1, store2, store3}) {
            store.takeOrder();
        }
    }
}
